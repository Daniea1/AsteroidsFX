package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {

    /**
     * IGamePluginService har en start og slut metode, som tager to argumenter Gamedata og World.
     * Skal kaldes når man starter spillet og igen når man slutter spillet
     *
     * Pre-condtion: At der findes en verden, den må ik være null.
     * Post-condtion: At man kan tilføje til verden.
     *
     * @param gameData
     * @param world
     * @throws
     */

    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
