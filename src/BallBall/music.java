package BallBall;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class music {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("BGMtest.WAV");
		playsound(file);
		
	}
	static void playsound(File sound){
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength()/1000);
		}
		catch(Exception e){
			
		}
	}

}
