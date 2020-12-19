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
int score = 0;
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
	checkCollision();
	purgeObjects();
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
		if(aliens.get(i).isActive == false) {
		aliens.remove(i);
		}
	}
	for (int i = 0; i < projectiles.size(); i++) {
		if(projectiles.get(i).isActive == false) {
			projectiles.remove(i);
		}
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
	for (Alien alien: aliens) {
		if (alien.collisionBox.intersects(rocket.collisionBox)) {
		alien.isActive = false;
		rocket.isActive = false;
		} for (Projectile projectile : projectiles) {
			if (projectile.collisionBox.intersects(alien.collisionBox)) {
				projectile.isActive = false;
				alien.isActive = false;
				score++;
			}
		}
	}
	
}
int getScore(){
	return score;
}
}
