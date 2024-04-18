import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module CollisionSystem {
    requires Common;
    requires CommonBullet;
    requires Asteroids;
    requires Player;
    requires Enemy;
    requires CommonAsteroids;
    requires CommonPlayer;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.collisionsystem.CollisionControlSystem;
}