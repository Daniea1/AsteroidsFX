package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollisionControlSystemTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isCollided() {
            Entity asteroid = new Entity();
            Entity bullet = new Entity();
            asteroid.setPolygonCoordinates(20, 0, 14, 14, 0, 20, -14, 14, -20, 0, -14, -14, 0, -20, 14, -14);
            bullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);

            asteroid.setX(10);
            asteroid.setY(10);
            bullet.setX(15);
            bullet.setY(15);

            CollisionControlSystem collisionControlSystem = new CollisionControlSystem();

            assertTrue(collisionControlSystem.isCollided(asteroid, bullet));
        }
        @Test
        void isNotCollided() {

            Entity asteroid = new Entity();
            Entity bullet = new Entity();
            asteroid.setPolygonCoordinates(20, 0, 14, 14, 0, 20, -14, 14, -20, 0, -14, -14, 0, -20, 14, -14);
            bullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);

            asteroid.setX(10);
            asteroid.setY(10);
            bullet.setX(150);
            bullet.setY(150);

            CollisionControlSystem collisionControlSystem = new CollisionControlSystem();

            assertFalse(collisionControlSystem.isCollided(asteroid, bullet));
        }
}