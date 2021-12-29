
public class Room3 extends Room{
	
	public Room3() {
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
		
		nextRoomR(0,400,590,785, new Room2());
		nextRoomL(795,400,590,30, new Room4());


	}
}