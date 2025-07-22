package game.world.tiles;
import game.buildings.BuildingType;
import java.util.List;

public class Forest extends Tile{

    /**
     * Constructor for Forest tile.
     * Initializes the tile with its terrain type and allowed building types.
     */
    public Forest() {
        super(TerrainType.FOREST, List.of(BuildingType.LUMBERMILL, BuildingType.SHOP), "Unnamed forest");
    }

    // Provides a description of the tile when visited.
    @Override
    protected String baseDescription() {
        return "A dense forest filled with towering trees and rich wildlife.";
    }

    // Provides a description of the tile when there are no buildings present.
    @Override
    protected String noBuildingFlavor() {
        return "The forest is quiet, with only the sounds of nature surrounding you.";
    }

}
