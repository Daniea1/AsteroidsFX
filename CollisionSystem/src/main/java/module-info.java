import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module CollisionSystem {
    requires Common;
    requires CommonBullet;
    requires Asteroids;
    provides IPostEntityProcessingService with dk.sdu.mmmi.cbse.collisionsystem.CollisionControlSystem;
}