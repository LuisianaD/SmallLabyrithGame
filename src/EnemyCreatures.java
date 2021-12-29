import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class EnemyCreatures {
	
	int x;
	int y;
	int w;
	int h;
	int health;
	boolean defeated = false;
	boolean damage = false;
	boolean c;
	
	String image1 = "";
	String image2 = "";
	Image frame1 = Toolkit.getDefaultToolkit().getImage(image1);
	Image frame2 = Toolkit.getDefaultToolkit().getImage(image2);
	Rect rx = new Rect(x,y,w,h);
	
	
	public EnemyCreatures(int x, int y,Rect rx, int health, String frame1, String frame2) {
		
		this.x = x;
		this.y = y;
		this.rx = rx;
		this.health = health;
		this.frame1 = Toolkit.getDefaultToolkit().getImage(frame1);
		this.frame2 = Toolkit.getDefaultToolkit().getImage(frame2);
	
	}
	
	public void draw(Graphics pen)
	{
		
		if(damage == true) {
		pen.drawImage(frame2, this.x, this.y, null);
		}
		else {
			pen.drawImage(frame1, this.x, this.y, null);
		}
		damage = false;
		
		rx = new Rect(x, y, 212, 159);
		
	}
	
	public void damaged(int x) {
		
		damage = true;
		health -= x;		
	}
	
	//Getters
	public int getX() {
		return x;
	}
	
	
	public int getY() {
		return y;
	}
	
	
	public Rect getRectangle() {
		return rx;
	}
	
	
	public boolean getDefeated() {
		return defeated;
	}
	
	public boolean getc() {
		return c;
	}

	public boolean isDefeated() {
		if (health <= 0){
			setPosition(-100,-100);
			defeated = true;
		}
		return defeated;
	}

	//Setters
	public void setc(boolean b) {
		c = b;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

}
