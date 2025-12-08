package com.comp2042;

import javafx.scene.media.AudioClip;
import java.net.URL;

/**
 * Singleton class responsible for managing audio playback in the game.
 * Handles loading and playing of sound effects (e.g., line clears) and
 * background music.
 * Ensures only one instance of the sound manager exists.
 */
public class SoundManager {

    private static SoundManager instance;
    private AudioClip clearSound;

    private javafx.scene.media.MediaPlayer backgroundMusic;

    // Private constructor for Singleton
    private SoundManager() {
        loadSounds();
        loadBackgroundMusic();
    }

    public static SoundManager getInstance() {
        if (instance == null) {
            instance = new SoundManager();
        }
        return instance;
    }

    private void loadSounds() {
        try {
            // Load "fried-chicken-eating-sound-effect.wav" for line clear
            URL clearUrl = getClass().getResource("/fried-chicken-eating-sound-effect.wav");
            if (clearUrl != null) {
                clearSound = new AudioClip(clearUrl.toExternalForm());
            } else {
                System.err.println("SoundManager: Sound file not found: /fried-chicken-eating-sound-effect.wav");
            }
        } catch (Exception e) {
            System.err.println("SoundManager: Error loading sounds: " + e.getMessage());
        }
    }

    private void loadBackgroundMusic() {
        try {
            // Load "Tetris Theme - Korobeiniki (Angklung Version).wav"
            URL musicUrl = getClass().getResource("/Tetris Theme - Korobeiniki (Angklung Version).wav");
            if (musicUrl != null) {
                javafx.scene.media.Media media = new javafx.scene.media.Media(musicUrl.toExternalForm());
                backgroundMusic = new javafx.scene.media.MediaPlayer(media);
                backgroundMusic.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);
            } else {
                System.err.println(
                        "SoundManager: Music file not found: /Tetris Theme - Korobeiniki (Angklung Version).wav");
            }
        } catch (Exception e) {
            System.err.println("SoundManager: Error loading music: " + e.getMessage());
        }
    }

    public void playClearSound() {
        if (clearSound != null) {
            clearSound.play();
        }
    }

    public void playBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.play();
        }
    }

    public void stopBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
        }
    }

    public void pauseBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.pause();
        }
    }

    // Placeholder for future sounds
    public void playMoveSound() {
        // Implement when referenced
    }

    public void playRotateSound() {
        // Implement when referenced
    }

    public void playGameOverSound() {
        // Implement when referenced
    }
}
