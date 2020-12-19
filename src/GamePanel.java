import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font subtitleFont;
	Timer frameDraw;
	Timer alienSpawn;
	Rocketship rocketship = new Rocketship(250,700,50,50);
	ObjectManager objectmanager = new ObjectManager(rocketship);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
public static void main(String[] args) {
	
}
GamePanel(){
	titleFont = new Font("Arial", Font.PLAIN, 48);
	subtitleFont = new Font("Comic Sans",Font.ITALIC,30);
	 frameDraw = new Timer(1000/60,this);
	 frameDraw.start();
	 if (needImage) {
		    loadImage ("space.png");
		}
}

@Override

public void paintComponent(Graphics g) {
	if(currentState == MENU){
	    drawMenuState(g);
	}else if(currentState == GAME){
	    drawGameState(g);
	}else if(currentState == END){
	    drawEndState(g);
	}


	}
	

void updateMenuState() {
	
}
void updateGameState() {
	objectmanager.update();
	if (rocketship.isActive = false) {
		currentState = END;
	}
}
void updateEndState() {
	
}
void drawMenuState(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titleFont);
	g.setColor(Color.YELLOW);
	g.drawString("LEAGUE INVADERS", 30, 100);
	g.setFont(subtitleFont);
	g.drawString("Press ENTER to start", 90, 300);
	g.drawString("Press SPACE for instructions", 50, 500);
}
void drawGameState(Graphics g) {
	String currentscore = Integer.toString(objectmanager.getScore());
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	if (gotImage) {
		g.drawImage(image, 0, 0, LeagueInvaders.WIDTH,LeagueInvaders.HEIGHT, null);
	} else {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH , LeagueInvaders.HEIGHT);
	}
	objectmanager.draw(g);
	g.setFont(subtitleFont);
	g.setColor(Color.RED);
	g.drawString(currentscore, 30, 50);
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titleFont);
	g.setColor(Color.YELLOW);
	g.drawString("Game Over", 120, 100);
	g.setFont(subtitleFont);
	g.drawString("You killed  enemies", 95, 300);
	g.drawString("Press ENTER to restart", 80, 500);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(currentState == MENU){
	    updateMenuState();
	}else if(currentState == GAME){
	    if (rocketship.up == true) {
			rocketship.up();
		}
	    if(rocketship.down == true) {
	    	rocketship.down();
	    }
	    if(rocketship.left == true) {
	    	rocketship.left();
	    }
	    if (rocketship.right == true) {
			rocketship.right();
		}
		updateGameState();
	}else if(currentState == END){
	    updateEndState();
	}

	System.out.println("action");
	repaint();
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if (e.getKeyCode()==KeyEvent.VK_ENTER) {
	    if (currentState == END) {
	        currentState = MENU;
	      
	        
	    } else {
	        currentState++;
	      if (currentState == GAME) {
	    	  startGame();
		} else {
			alienSpawn.stop();
		}
	    }
	    
	} 

	if (currentState == GAME) {
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			 rocketship.up = true;
			rocketship.up();
	        
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			rocketship.down = true;
			rocketship.down();
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			rocketship.left = true;
			rocketship.left();	
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			rocketship.right = true;
			rocketship.right();
		}
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			objectmanager.addProjectile(rocketship.getProjectile());
		}
	}
	
	
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub

	if (currentState == GAME) {
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		   rocketship.up = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			rocketship.down = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			rocketship.left = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			rocketship.right = false;
		}
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
void startGame() {
    alienSpawn = new Timer(1000 , objectmanager);
    alienSpawn.start();
}

}
