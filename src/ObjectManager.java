import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship rocket;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();
Random random = new Random();
public static void main(String[] args) {
	
}
ObjectManager(Rocketship rocketship){
rocket = rocketship;
}
void addAlien(){
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
void update() {
	
}
}
