import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

Rocketship(int x, int y, int width, int height){
	super(x,y,width,height);
	speed = 10;
	if (needImage) {
	    loadImage ("rocket.png");
	}
}
void draw(Graphics g) {
	g.setColor(Color.BLUE);
    g.fillRect(x, y, width, height);
    if (gotImage) {
    	g.drawImage(image, x, y, width, height, null);
    } else {
    	g.setColor(Color.BLUE);
    	g.fillRect(x, y, width, height);
    }


}
 void up() {
	  if(y>0 && up == true) {
		  y-=speed;
	  }
 }
 void down() {
	 if (y<LeagueInvaders.HEIGHT - 70 && down == true) {
		y+=speed; 
	}

 }
 void left() {
	 if (x>0 && left == true) {
		 x-=speed;
	}
	
 }
 void right() {
	 if(x<LeagueInvaders.WIDTH - 50 && right == true) {
		 x+=speed;
	 }
 }
 void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }	
 
}
 public Projectile getProjectile() {
     return new Projectile(x+width/2, y, 10, 10);
} 
}