package audio;

import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {

	public AudioPlayer(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// Create AudioInputStream object
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

		// Create clip reference
		Clip clip = AudioSystem.getClip();

		// Open audioInputStream to the clip
		clip.open(audioInputStream);

		// Plays the sound
		clip.start();

	}

}