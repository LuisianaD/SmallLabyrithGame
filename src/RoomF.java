
public class RoomF extends Room {

		public RoomF() {
			super("forest-background_F.png", "grassF.png"); 
			
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
			
			if (mage.overlaps(r4)) { //right
				mage.x -= 5;	
			}



		}


}
