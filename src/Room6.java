
public class Room6 extends Room{
	
	
	public Room6() {
		super("forest-background_3.png", "grass03.png");
		// TODO Auto-generated constructor stub
	}
	
	public void inGameLoop() {
		
		
		if (mage.overlaps(r1)) { //top 
			mage.y += 5;
	    }
		
		if (mage.overlaps(r2)) { //bottom 
			mage.y -= 5;
		}
		
		
		nextRoomR(0,400,590,785, new Room5());
		nextRoomL(795,400,590,100, new Room8());

	}
}