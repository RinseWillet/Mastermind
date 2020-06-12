import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class soundEffects {
	
	public soundEffects() {
		
	}
	
	void bad () {
		File bad = new File("wahwah.wav");
		PlaySound(bad);
	}
	
	void good () {
		File good = new File("owin31.wav");
		PlaySound(good);
	}
	
	static void PlaySound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
			
		} catch (Exception e) {
		}
	}

}
