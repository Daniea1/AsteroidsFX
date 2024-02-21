package dk.sdu.mmmi.cbse.asteroidssystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
public class AsteroidsPlugin implements IGamePluginService {

    private Entity Asteroids;

    public AsteroidsPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        Asteroids = createAsteroids(gameData);
        world.addEntity(Asteroids);
    }

    private Entity createAsteroids(GameData gameData) {

        Entity asteroids = new Asteroids();
        asteroids.setPolygonCoordinates(0, -10, 8, -5, 8, 5, 0, 10, -8, 5, -8, -5);
        asteroids.setX(gameData.getDisplayWidth()/2);
        asteroids.setY(0);
        asteroids.setRotation(90);
        return asteroids;
    }

    @Override
    public void stop(GameData gameData, World world) {
        for (Entity e : world.getEntities()) {
            if (e.getClass() == Bullet.class) {
                world.removeEntity(e);
            }
        }
    }

}
