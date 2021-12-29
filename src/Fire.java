import java.awt.Color;
import java.awt.Graphics;

//I miss the opportunity to name this Friendly Fire 
public class Fire {
	
	int x;
	int y;

	double vx = 0;
	double vy = 0;
	boolean L = true;
	
	
	public Fire(int x, int y) { 
		this.x = x;
		this.y = y;
	}
	
	Color fillColor = Color.RED;
	Color drawColor = Color.BLACK;
	
	
	public void draw(Graphics pen) {
		

		pen.setColor(fillColor);
		pen.fillOval(x, y, 10, 10);		
		pen.setColor(drawColor);
		pen.drawOval(x, y, 10, 10);	
	}
	
	public void move() {
		this.x += vx;
		this.y += vy;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public void setVelocity(int speed)
	{
		vx = speed;	
	}
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Rect getRectangle() {
		
		Rect r = new Rect(x, y, 64, 64);
		return r;
	}
	
	
	public void setL(boolean b) {
		L = b;
	}
	
	public boolean getL() {
		return L;
	}
	

}
