import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	
	public static void play(String s, Boolean start, float volumen)throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		  File file = new File(s); //No final option, music files need to be .wav files and 16bits
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		  Clip clip = AudioSystem.getClip();
		  clip.open(audioStream);
		  FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		  gainControl.setValue(volumen);
		  clip.start();
		  
		  if(start == true) { 
			  clip.loop(Clip.LOOP_CONTINUOUSLY);
		  }else if(start == false){
			  clip.setLoopPoints(0, 1);
		  }  
	}

}
