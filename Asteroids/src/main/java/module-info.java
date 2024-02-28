
import dk.sdu.mmmi.cbse.asteroidsystem.AsteroidsControlSystem;
import dk.sdu.mmmi.cbse.asteroidsystem.AsteroidsPlugin;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Asteroids {
    exports dk.sdu.mmmi.cbse.asteroidsystem;
    requires Common;
    requires CommonBullet;   
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    provides IGamePluginService with AsteroidsPlugin;
    provides IEntityProcessingService with AsteroidsControlSystem;
    
}

//