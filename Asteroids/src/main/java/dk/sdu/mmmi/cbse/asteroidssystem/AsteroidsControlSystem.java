package dk.sdu.mmmi.cbse.asteroidssystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;


public class AsteroidsControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {

        Random random = new Random();
        int randomInt = random.nextInt(150);

            for (Entity Asteroids : world.getEntities(Asteroids.class)) {
                double changeX = Math.cos(Math.toRadians(Asteroids.getRotation()));
                double changeY = Math.sin(Math.toRadians(Asteroids.getRotation()));
                Asteroids.setX(Asteroids.getX() + changeX);
                Asteroids.setY(Asteroids.getY() + changeY);
            }
            if (randomInt ==1) {

                Entity asteroids = new Asteroids();
                asteroids = createAsteroids(gameData);
                world.addEntity(asteroids);
            }

}

    private Entity createAsteroids(GameData gameData) {
        Random random = new Random();
        int randomXwidth = random.nextInt(gameData.getDisplayWidth());

        Entity asteroids = new Asteroids();
        asteroids.setPolygonCoordinates(0, -20, 16, -10, 16, 10, 0, 20, -16, 10, -16, -10);
        asteroids.setX(randomXwidth);
        asteroids.setY(0);
        asteroids.setRotation(90);
        return asteroids;
    }

}


