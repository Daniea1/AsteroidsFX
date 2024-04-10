package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.asteroidsystem.Asteroids;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.enemysystem.Enemy;
import dk.sdu.mmmi.cbse.playersystem.Player;

import static java.lang.Math.sqrt;


public class CollisionControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        // for loop for collision between bullet and asteroids
        for (Entity entityBullet : world.getEntities(Bullet.class)) {
            for (Entity entityAsteroid : world.getEntities(Asteroids.class)) {
                if (isCollided(entityAsteroid, entityBullet)) {
                    entityAsteroid.setHitPoints(entityAsteroid.getHitPoints() - 1);
                    if (entityAsteroid.getHitPoints()<1){
                        world.removeEntity(entityAsteroid);
                    }
                    world.removeEntity(entityBullet);
                }
            }
        }

        // for loop for collision between ship and asteroids
        for (Entity entityShip : world.getEntities(Player.class)) {
            for (Entity entityAsteroid : world.getEntities(Asteroids.class)) {
                if (isCollided(entityAsteroid, entityShip)) {
                    world.removeEntity(entityShip);
                }
            }
        }

        // for loop for collision between bullet and Enemy
        for (Entity entityEnemy : world.getEntities(Enemy.class)) {
            for (Entity entityBullet : world.getEntities(Bullet.class)) {
                if (isCollided(entityEnemy, entityBullet)) {
                    entityEnemy.setHitPoints(entityEnemy.getHitPoints()-1);
                    if (entityEnemy.getHitPoints()<1) {
                        world.removeEntity(entityEnemy);
                    }
                    world.removeEntity(entityBullet);
                }
            }
        }

        // for loop for collision between bullet and Player
        for (Entity entityPlayer : world.getEntities(Player.class)) {
            for (Entity entityBullet : world.getEntities(Bullet.class)) {
                if (isCollided(entityPlayer, entityBullet)) {
                    entityPlayer.setHitPoints(entityPlayer.getHitPoints()-1);
                    if (entityPlayer.getHitPoints()<1) {
                        world.removeEntity(entityPlayer);
                    }
                    world.removeEntity(entityBullet);
                }
            }
        }

    }

    public boolean isCollided(Entity e1, Entity e2) {

        double x1 = e1.getX();
        double y1 = e1.getY();

        double x2 = e2.getX();
        double y2 = e2.getY();

        double result = sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
        double e1Width = e1.getWidth() / 2;
        double e2Width = e2.getWidth() / 2;


        if (result < e1Width + e2Width) {
            return true;
        }

        return false;
    }

}