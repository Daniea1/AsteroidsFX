package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.cbse.common.asteroids.Asteroids;
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

            for (Entity bigAsteroids : world.getEntities(Asteroids.class)) {
                double changeX = Math.cos(Math.toRadians(bigAsteroids.getRotation()));
                double changeY = Math.sin(Math.toRadians(bigAsteroids.getRotation()));
                bigAsteroids.setX(bigAsteroids.getX() + changeX);
                bigAsteroids.setY(bigAsteroids.getY() + changeY);

                if (bigAsteroids.getHealthPoints() == 2){

                    Entity asteroidsSmallRight = new Asteroids();
                    asteroidsSmallRight.setPolygonCoordinates(0, -10, 8, -5, 8, 5, 0, 10, -8, 5, -8, -5);
                    asteroidsSmallRight.setX(bigAsteroids.getX());
                    asteroidsSmallRight.setY(bigAsteroids.getY());
                    asteroidsSmallRight.setRotation(bigAsteroids.getRotation()+15);
                    world.addEntity(asteroidsSmallRight);

                    Entity asteroidsSmallLeft = new Asteroids();
                    asteroidsSmallLeft.setPolygonCoordinates(0, -10, 8, -5, 8, 5, 0, 10, -8, 5, -8, -5);
                    asteroidsSmallLeft.setX(bigAsteroids.getX());
                    asteroidsSmallLeft.setY(bigAsteroids.getY());
                    asteroidsSmallLeft.setRotation(bigAsteroids.getRotation()-15);
                    world.addEntity(asteroidsSmallLeft);

                    world.removeEntity(bigAsteroids);
                }

            }

            if (randomInt ==1) {

                Entity asteroids;
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
        asteroids.setHealthPoints(4);
        return asteroids;
    }

}


