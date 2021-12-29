import java.awt.Graphics;

public class Room {
	
	Background background;
	ImageLayer imageLayer;
	Fire[] f = new Fire[50];
	boolean monster = false;
	static MC mage;
	static EnemyCreatures Slime;
	static Room current;
	
	
    Rect r1 = new Rect(0,400,800,1); //Upper Line
    Rect r2 = new Rect(0,590,800,1);  //Botton Line
    Rect r3 = new Rect(0, 0,1,800); //Left Line
    Rect r4 = new Rect(795, 450,1,800); //Right Line
	
	
	public Room(String filename_1, String filename_2) {
		
	    Rect r1 = new Rect(0,400,800,1); //Upper Line
	    Rect r2 = new Rect(0,590,800,1);  //Botton Line
	    Rect r3 = new Rect(0, 0,1,800); //Left Line
	    Rect r4 = new Rect(795, 450,1,800); //Right Line
	    //Exit will be like 400x590
		
		background = new Background(filename_1);
		imageLayer = new ImageLayer(filename_2, 0, 450,1);
		Slime = new Slime(400,310); //212x519
		
		
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
		
		if(mage.overlaps(Slime.getRectangle()) && monster == true) {
			pop(100,500, new Room1());
		}
			
		
		
	}
	
	public void draw(Graphics pen) {
		
		
		background.draw(pen);
		imageLayer.draw(pen);
		mage.draw(pen);
		
		if(Slime.isDefeated() == true) {
			monster = false;
		}
		
		if(monster == true) {
			Slime.draw(pen);
			
			if (Slime.getDefeated() == false && Slime.getc() == false) {
				
				Slime.isDefeated();
			}
		
		}
		
		
	
	}
	
	
	
	public void pop(int x, int y,Room room) {
			Room.current = room;
			mage.x = x;
			mage.y = y;
	}
	
	
	public void nextRoomL(int x, int y1,int y2, int popUp, Room room) {
		if((mage.x > x) && (mage.y > y1) && (mage.y < y2)) {
			Room.current = room;
			mage.x = popUp;
		}
	}
	
	public void nextRoomR(int x, int y1,int y2, int popUp, Room room) {
		if((mage.x < x) && (mage.y > y1) && (mage.y < y2)) {
			Room.current = room;
			mage.x = popUp;
		}
	}

}
