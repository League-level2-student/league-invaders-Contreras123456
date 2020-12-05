import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
Rocketship rocket;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();
Random random = new Random();
public static void main(String[] args) {
	
}
ObjectManager(Rocketship rocketship){
rocket = rocketship;
addAlien();
}

	// TODO Auto-generated constructor stub

void addAlien(){
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	
}
void update() {
for (int i = 0; i < aliens.size(); i++) {
	aliens.get(i).update();
	if (aliens.get(i).y> LeagueInvaders.HEIGHT) {
		aliens.get(i).isActive = false;
	}
}	
for (int i = 0; i < projectiles.size(); i++) {
	projectiles.get(i).update();
	if (projectiles.get(i).y> LeagueInvaders.HEIGHT) {
		projectiles.get(i).isActive = false;
	}
}

}
void draw(Graphics g) {
	rocket.draw(g);
	for (int i = 0; i < aliens.size(); i++) {
		aliens.get(i).draw(g);
	}
	for (int i = 0; i < projectiles.size(); i++) {
		projectiles.get(i).draw(g);
	}
}
void purgeObjects() {
	for (int i = 0; i < aliens.size(); i++) {
		aliens.get(i).isActive = true;
	}
	for (int i = 0; i < projectiles.size(); i++) {
		projectiles.get(i).isActive = true;
	}
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	addAlien();
}
public void addProjectile(Projectile projectile) {
	// TODO Auto-generated method stub
	projectiles.add(new Projectile(rocket.x,rocket.y,50,50));
}
void checkCollision() {
	
}
}
