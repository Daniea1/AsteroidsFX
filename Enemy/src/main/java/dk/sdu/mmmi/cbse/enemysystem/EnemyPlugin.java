package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
public class EnemyPlugin implements IGamePluginService {

    private Entity Enemy;

    public EnemyPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        Enemy = createPlayerShip(gameData);
        world.addEntity(Enemy);
    }

    private Entity createPlayerShip(GameData gameData) {

        Entity enemyShip = new Enemy();
        enemyShip.setPolygonCoordinates(-7,-7,12,0,-7,7);
        enemyShip.setX(gameData.getDisplayHeight()/2);
        enemyShip.setY(gameData.getDisplayWidth()/2);
        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(Enemy);
    }

}
