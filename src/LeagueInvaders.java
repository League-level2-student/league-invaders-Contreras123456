import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame;
	JPanel panel = new JPanel();
	GamePanel gamepanel;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	

	LeagueInvaders(){
		frame = new JFrame();
	 gamepanel = new GamePanel();
	}	
public static void main(String[] args) {
	LeagueInvaders leagueinvaders = new LeagueInvaders();
	leagueinvaders.setup();
	
}
void setup() {
	frame.add(gamepanel);
	frame.setSize(WIDTH,HEIGHT);
	frame.setVisible(true);
	frame.add(panel);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}

}

