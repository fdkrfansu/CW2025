package com.comp2042;

public interface InputEventListener {

    DownData onDownEvent(MoveEvent event);

    ViewData onLeftEvent(MoveEvent event);

    ViewData onRightEvent(MoveEvent event);

    ViewData onRotateEvent(MoveEvent event);

    ViewData onRotateAntiClockwiseEvent(MoveEvent event);

    ViewData onHoldEvent(MoveEvent event);

    DownData onHardDropEvent(MoveEvent event);

    void init();

    void startGame();

    void stopGame();

    void createNewGame();
}
// Force IDE Refresh
