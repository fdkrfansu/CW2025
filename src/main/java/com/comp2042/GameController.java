package com.comp2042;

public class GameController implements InputEventListener {

    private Board board = new SimpleBoard(25, 10);

    private final GuiController viewGuiController;
    private final javafx.animation.Timeline timeLine;

    private int lastScoreCheck = 0;
    private double currentAnimateSpeed = 600.0;

    public GameController(GuiController c) {
        viewGuiController = c;
        board.createNewBrick();
        viewGuiController.setEventListener(this);
        viewGuiController.initGameView(board.getBoardMatrix(), board.getViewData());
        viewGuiController.bindScore(board.getScore().scoreProperty());
        viewGuiController.bindLinesCleared(board.getLinesClearedProperty());

        timeLine = new javafx.animation.Timeline(new javafx.animation.KeyFrame(
                javafx.util.Duration.millis(currentAnimateSpeed),
                ae -> {
                    DownData data = onDownEvent(new MoveEvent(EventType.DOWN, EventSource.THREAD));
                    viewGuiController.refreshBrick(data.getViewData());
                }));
        timeLine.setCycleCount(javafx.animation.Timeline.INDEFINITE);
    }

    @Override
    public void init() {
        // Game will start when user clicks Play button
    }

    @Override
    public void startGame() {
        timeLine.play();
    }

    @Override
    public void stopGame() {
        timeLine.stop();
    }

    @Override
    public DownData onDownEvent(MoveEvent event) {
        boolean canMove = board.moveBrickDown();
        ClearRow clearRow = null;
        if (!canMove) {
            board.mergeBrickToBackground();
            clearRow = board.clearRows();
            if (clearRow.getLinesRemoved() > 0) {
                board.getScore().add(clearRow.getScoreBonus());
                updateGameSpeed();
            }
            if (board.createNewBrick()) {
                viewGuiController.gameOver();
                stopGame();
            }

            viewGuiController.refreshGameBackground(board.getBoardMatrix());
            viewGuiController.refreshBrick(board.getViewData());

        } else {
            if (event.getEventSource() == EventSource.USER) {
                // board.getScore().add(1);
            }
        }
        return new DownData(clearRow, board.getViewData());
    }

    @Override
    public ViewData onHoldEvent(MoveEvent event) {
        board.holdBrick();
        return board.getViewData();
    }

    @Override
    public DownData onHardDropEvent(MoveEvent event) {
        board.dropBrick();
        ClearRow clearRow = null;
        board.mergeBrickToBackground();
        clearRow = board.clearRows();
        if (clearRow.getLinesRemoved() > 0) {
            board.getScore().add(clearRow.getScoreBonus());
            updateGameSpeed();
        }
        if (board.createNewBrick()) {
            viewGuiController.gameOver();
            stopGame();
        }
        viewGuiController.refreshGameBackground(board.getBoardMatrix());
        return new DownData(clearRow, board.getViewData());
    }

    @Override
    public ViewData onLeftEvent(MoveEvent event) {
        board.moveBrickLeft();
        return board.getViewData();
    }

    @Override
    public ViewData onRightEvent(MoveEvent event) {
        board.moveBrickRight();
        return board.getViewData();
    }

    @Override
    public ViewData onRotateEvent(MoveEvent event) {
        board.rotateLeftBrick();
        return board.getViewData();
    }

    @Override
    public void createNewGame() {
        board.newGame();
        lastScoreCheck = 0;
        currentAnimateSpeed = 600.0;
        timeLine.stop();
        timeLine.getKeyFrames().clear();
        timeLine.getKeyFrames().add(new javafx.animation.KeyFrame(
                javafx.util.Duration.millis(currentAnimateSpeed),
                ae -> {
                    DownData data = onDownEvent(new MoveEvent(EventType.DOWN, EventSource.THREAD));
                    viewGuiController.refreshBrick(data.getViewData());
                }));
        viewGuiController.refreshGameBackground(board.getBoardMatrix());
        startGame();
    }

    private void updateGameSpeed() {
        int score = board.getScore().scoreProperty().getValue();
        if (score >= lastScoreCheck + 500) {
            lastScoreCheck += 500;
            currentAnimateSpeed = Math.max(50, currentAnimateSpeed - 50); // Decrease delay by 50ms

            timeLine.stop();
            timeLine.getKeyFrames().clear();
            timeLine.getKeyFrames().add(new javafx.animation.KeyFrame(
                    javafx.util.Duration.millis(currentAnimateSpeed),
                    ae -> {
                        DownData data = onDownEvent(new MoveEvent(EventType.DOWN, EventSource.THREAD));
                        viewGuiController.refreshBrick(data.getViewData());
                    }));
            timeLine.play();

            System.out.println("Speed increased! New Delay: " + currentAnimateSpeed);
        }
    }
}
