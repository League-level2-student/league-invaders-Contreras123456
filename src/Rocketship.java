import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Rocketship extends GameObject {
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
Rocketship(int x, int y, int width, int height){
	super(x,y,width,height);
	speed = 10;
}
void draw(Graphics g) {
	g.setColor(Color.BLUE);
    g.fillRect(x, y, width, height);

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
}
 