
public class Room4 extends Room{
	
	public Room4() {
		super("forest-background_2.png", "grass02.png");
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
		

		
		nextRoomR(0,400,590,785, new Room3());
		nextRoomL(795,400,590,30, new Room5());


	}
}