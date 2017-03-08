package BallBall;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audioplayertest {
	Clip clip;
	
	Audioplayertest(String sound){
		File file = new File(sound);
		try{
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
		}
		catch(Exception e){
			
		}
	}
	public void musicstart(){
		clip.loop(0);
	}
	public void musicstop(){
		clip.stop();
	}
}
