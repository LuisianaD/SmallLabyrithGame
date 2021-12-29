import java.awt.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class GameRPG extends GameBase{
	
	MC mage = new MC(100, 500); //64x64
	EnemyCreatures Slime = new Slime(400,310);
	boolean locked = false;
	int cur = 1;
	int room = 1;
	Fire[] f = new Fire[100];

	Rect rx = new Rect(400, 400, 212, 159);


	@Override
	public void initialize() {
		
		
		Frame title = (Frame)this.getParent().getParent();
		title.setTitle("Back To The Forest");
		try {
			Sound.play("forest.wav", true, 0.0f);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	    for(int i = 0; i < f.length; i++) {
			
			f[i] = new Fire(-1000, -1000);
			
	    }
	    
		Room.mage = mage;
		Room.current = new Room1();
		

		
	}

	
	//Run()
	@Override
	public void inGameLoop() {
		
		
		if(pressing[UP])   {
			mage.moveUp(4);
		}
		if(pressing[DN]) {
			mage.moveDown(4);
		}
		if(pressing[RT]) {
			mage.moveRight(4);
		}
		if(pressing[LT]) {
			mage.moveLeft(4);
		}
	
		
		if(pressing[SPACE] && !locked)  
		{
			locked = true;
			mage.shoot(f[cur]);
			
			cur++;
			
			if(cur == f.length)   cur = 0;
			
			try {
				Sound.play("Fire.wav", false, -40.0f);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!pressing[SPACE]) {
			locked = false;  
		}
		
		cur++;
		
		if(cur == f.length) {
			cur = 0;
			
		
		}	
		
		Room.current.inGameLoop();
		
		
	}
	
	public void paint(Graphics pen) {
		
		resize(800, 600);
		
		Room.current.draw(pen);
		
		for(int i = 0; i < f.length; i++) {
			f[i].move();
			if ((f[i].getRectangle().overlaps(Slime.getRectangle()) && Room.current.monster == true)) { 
			    Slime.damaged(100);
			    System.out.print("Hit ");
			    f[i].setPosition(-10, -10);
			}
		
		}
		for(int j = 0; j < f.length; j++) { 
			f[j].draw(pen);	
			if ((f[j].getRectangle().overlaps(Slime.getRectangle()) && Room.current.monster == true)) { 
			    Slime.damaged(100);
			    System.out.print("Hit ");
			    f[j].setPosition(-10, -10);
			
			}
		}
	}
		
		

}
