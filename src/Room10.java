
public class Room10 extends Room{
	
	
	public Room10() {
		super("forest-background_1.png", "grass01.png");
		// TODO Auto-generated constructor stub
	}
	
	public void inGameLoop() {
		
		
		if (mage.overlaps(r1)) { //top 
			mage.y += 5;
	    }
		
		if (mage.overlaps(r2)) { //bottom 
			mage.y -= 5;
		}
		
		monster = true;
		if(mage.overlaps(Slime.getRectangle()) && monster == true) {
			pop(100,500, new Room1());
		}
		
		if(Slime.isDefeated() == true) {
			monster = false;
		}
		
		nextRoomR(0,400,590,785, new Room9());
		nextRoomL(795,400,590,100, new Room1());

	}

}

