
import dk.sdu.mmmi.cbse.AsteroidsControlSystem;
import dk.sdu.mmmi.cbse.AsteroidsPlugin;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Asteroids {
    exports dk.sdu.mmmi.cbse;
    requires Common;
    requires CommonBullet;   
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    provides IGamePluginService with AsteroidsPlugin;
    provides IEntityProcessingService with AsteroidsControlSystem, dk.sdu.mmmi.cbse.EntityProcessor;
    
}

//