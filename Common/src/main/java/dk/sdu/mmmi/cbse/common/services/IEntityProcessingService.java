package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {

    /**
     * IEntityProcessingService har en process metode, som bruges til at proces når fx player bevæger
     * sig fremad.
     *
     * Pre-condtion: At der er gameData og en world at process
     * Post-condtioon: At man kan process det overstående.
     *
     * @param gameData
     * @param world
     * @throws
     */
    void process(GameData gameData, World world);
}
