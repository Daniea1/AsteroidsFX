
import dk.sdu.mmmi.cbse.asteroidsystem.AsteroidsControlSystem;
import dk.sdu.mmmi.cbse.asteroidsystem.AsteroidsPlugin;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Asteroids {
    requires Common;
    requires CommonAsteroids;
    provides IGamePluginService with AsteroidsPlugin;
    provides IEntityProcessingService with AsteroidsControlSystem;
    
}

//