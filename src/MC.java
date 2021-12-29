import java.awt.Color;
import java.awt.Graphics;

public class MC extends Sprite{

	static String[] pose = {"_up_","_dn_","_lt_","_rt_", };
	Rect hitbox = new Rect(x,y, 64,64);
	
	public MC(int x, int y) {
		super(x, y,64,64, "m", pose, 4, "png", 10);
		hitbox = new Rect(x,y, 64,64);
		// TODO Auto-generated constructor stub
	}

	public MC(int x, int y, int w, int h) {
		super(x, y, w, h, "m", pose, 4, "png", 10);
		hitbox = new Rect(x,y, 64,64);
		// TODO Auto-generated constructor stub
	}
	
	public void move()
	{
		x += vx;
		y += vy;
	}
	
	public void shoot(Fire f)
	{
		
		f.setPosition(x+32, y+14);
		f.setVelocity(10);

	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isHit(EnemyCreatures b) {
		if (b.getRectangle().overlaps(hitbox)) {
			return true;	
		}
		return false;
	}
	


}
