package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * IPostEntityProcessingService bliver ikke brugt endnu
 *
 * Pre-condtion: At der er gameData og en world at process
 * Post-condtioon: At man kan process det overstående.
 *
 */
public interface IPostEntityProcessingService {

    void process(GameData gameData, World world);
}
