# CW2025 - "Ayam Gepuk" Tetris Edition

## GitHub
[https://github.com/fdkrfansu/CW2025.git](https://github.com/fdkrfansu/CW2025.git)

## Compilation Instructions
This project is built using **Maven** and **JavaFX**.

**Prerequisites:**
-   Java JDK 21 or higher.
-   Maven 3.8+.

**Steps to Run:**
1.  Open a terminal in the project root directory.
2.  Clean and compile the project:
    ```bash
    mvn clean compile
    ```
3.  Run the application using the JavaFX Maven plugin:
    ```bash
    mvn javafx:run
    ```
    *Alternatively, if running the jar manually:*
    ```bash
    java -cp "target/classes;target/dependency/*" com.comp2042.Launcher
    ```

## Implemented and Working Properly
The following features have been successfully implemented and tested:

1.  **"Ayam Gepuk" Theme**: A complete visual overhaul with a custom restaurant interior background, wooden bordered game board, and a hidden "black plate" aesthetic.
2.  **Audio System**:
    -   **Background Music**: "Tetris Theme (Angklung Version)" loops during gameplay and stops in the main menu.
    -   **Sound Effects**: A unique "Crunch" sound effect plays when lines are cleared.
3.  **Menu System**:
    -   **Main Menu**: Custom start screen with "PLAY", "CONTROLS", and "EXIT" options.
    -   **Pause Menu**: In-game overlay allowing specific "Resume" or "Exit to Main Menu" actions.
    -   **Game Over Screen**: Displays "Too spicy for you?" with options to restart or exit.
    -   **Instructions Panel**: Lists all key bindings including the new "Anti-Clockwise" rotation.
4.  **Gameplay Extensions**:
    -   **Hold Piece**: Players can swap the current block with a held block (SHIFT key).
    -   **Ghost Block**: A visual guide showing where the current block will land (White outline).
    -   **Next Piece**: A preview panel showing the upcoming block.
    -   **Hard Drop**: Instantly drop blocks (SPACE key).
    -   **Leveling System**: Game speed increases slightly every 500 points for progressive difficulty.
    -   **Line Clear Popups**: "Double!", "Triple!", "Tetris!" text animations appear on scoring.

## Implemented but Not Working Properly
-   **N/A**: All implemented features (Audio, Menus, Gameplay mechanics) are currently functioning as designed.

## Features Not Implemented
1.  **High Score Persistence**: Saving scores to a file/database was not implemented due to time constraints focusing on the visual and audio experience.
2.  **Extended Sound Effects**: Sounds for block movement and rotation were skipped to prioritize the core Line Clear event and Background music integration.
3.  **Alternative Game Modes**: Modes like "Time Battle" or "Sprint" were planned but the "Endless" mode (with speed ramping) was chosen as the primary focus.

## New Java Classes
1.  **`SoundManager.java`**: Singleton class responsible for loading and playing audio assets (`AudioClip` for SFX, `MediaPlayer` for music) efficiently.
2.  **`MainMenuPanel.java`**: Represents the initial landing screen with navigation buttons, styled with `BorderPane`.
3.  **`PauseMenuScreen.java`**: Encapsulates the pause overlay logic and UI styling.
4.  **`GameOverPanel.java`**: Handles the game over state UI, including the restart and exit logic.
5.  **`InstructionsPanel.java`**: A dedicated panel displaying the control scheme text.
6.  **`NotificationPanel.java`**: Handles the creation of temporary floating text (e.g., "+100", "Tetris!") for user feedback.
7.  **`ColorMapper.java`**: Extracted logic that maps numerical block IDs to JavaFX `Color` objects, improving separation of concerns.
8.  **`Launcher.java`**: A standard entry point class to ensure JavaFX runtime initializes correctly when building/running as a JAR.

## Modified Java Classes
1.  **`GuiController.java`**:
    -   **Reason**: Central hub for the new UI. Modified to integrate `MainMenuPanel`, wire up the `SoundManager`, handle new key inputs (SHIFT for Hold, CTRL for Reverse Rotate), and manage the visibility of new HUD elements (Score, Hold, Next).
2.  **`GameController.java`**:
    -   **Reason**: Updated to handle the "Hold" logic (swapping blocks), implementing the speed increase algorithm based on score, and refining the game loop to support the new "Pause" state properly.
3.  **`SimpleBoard.java`**:
    -   **Reason**: Added `linesCleared` tracking to support the new HUD counter and modified matrix handling for safer updates (defensive copying).

## Unexpected Problems
1.  **Audio Dependency Missing**:
    -   *Issue*: The game crashed at runtime with `NoClassDefFoundError: javafx/scene/media/AudioClip`.
    -   *Resolution*: Identified that `javafx-media` was missing from `pom.xml`. Added the dependency and rebuilt the classpath.
2.  **Background Scaling**:
    -   *Issue*: The background image appeared zoomed in or tiled incorrectly on different screen sizes.
    -   *Resolution*: Adjusted CCS `background-size` to `100% 100%` to ensure it stretches to fill the window exactly as requested.
3.  **Text Truncation**:
    -   *Issue*: Large pixel fonts caused text to be cut off in buttons.
    -   *Resolution*: Increased button width to `300px` and adjusted font sizes in `InstructionsPanel` to fit the content.
