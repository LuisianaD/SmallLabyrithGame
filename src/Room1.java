import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Room1 extends Room{

	public Room1() {
		super("forest-background_1.png", "grass01.png"); 
		
	}
	
	public void inGameLoop() {
		
		
		if (mage.overlaps(r1)) { //top 
			mage.y += 5;
	    }
		
		if (mage.overlaps(r2)) { //bottom 
			mage.y -= 5;
		}
		
		if (mage.overlaps(r3)) { //left 
			mage.x += 5;	
		}
		


		nextRoomL(795,400,590,30, new Room2());

	}

}
