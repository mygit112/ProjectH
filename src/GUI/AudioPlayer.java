package GUI;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class AudioPlayer {

    private Clip clip;
    private String filePath1 = "res/catsong.wav";
    private String filePath2 = "res/Game.wav";
    
    public AudioPlayer() {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            System.err.println("LineUnavailableException: " + e.getMessage());
        }
    }
    
    public void startAudio(int i) {
        String filePath = (i == 1) ? filePath1 : filePath2;

        try (AudioInputStream aui = AudioSystem.getAudioInputStream(new File(filePath))) {
            clip.open(aui);
            clip.start();
            if (i == 1) {
                clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop indefinitely for the menu sound
            }
        } catch (UnsupportedAudioFileException e) {
            System.err.println("Unsupported audio file: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("LineUnavailableException: " + e.getMessage());
        }
    }
    
    public void resetAudio() {
        if (clip.isOpen()) {
            clip.setMicrosecondPosition(0);
        }
    }
    
    public void closeAudio() {
        if (clip.isOpen()) {
            clip.close();
        }
    }
    
    public void stopAudio() {
        if (clip.isRunning()) {
            clip.stop();
        }
    }
    
    public static void main(String[] args) {
        AudioPlayer ap = new AudioPlayer();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter command (1: Start Catsong, 11: Start Game, 2: Stop, 3: Reset, 4: Close): ");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    ap.startAudio(1);
                    break;
                case 11:
                    ap.startAudio(2);
                    break;
                case 2:
                    ap.stopAudio();
                    break;
                case 3:
                    ap.resetAudio();
                    break;
                case 4:
                    ap.closeAudio();
                    return; // Exit the program
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}
