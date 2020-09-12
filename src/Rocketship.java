import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

Rocketship(int x, int y, int width, int height){
	super(x,y,width,height);
	speed = 10;
}
void draw(Graphics g) {
	g.setColor(Color.BLUE);
    g.fillRect(x, y, width, height);

}
 void up() {
	  if(y>0) {
		  y-=speed;
	  }
 }
 void down() {
	 if (y<700) {
		y+=speed; 
	}

 }
 void left() {
	 if (x>0) {
		 x-=speed;
	}
	
 }
 void right() {
	 if(x<250) {
		 x+=speed;
	 }
 }
}
 