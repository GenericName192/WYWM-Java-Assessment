package game.world.tiles;
import game.buildings.BuildingType;
import java.util.List;

public class Lake extends Tile {
    public Lake() {
        super(TerrainType.LAKE, List.of(BuildingType.DOCK, BuildingType.SHOP), "Unnamed lake");
    }

    @Override
    protected String baseDescription() {
        return "A serene lake with crystal clear waters, surrounded by lush greenery.";
    }

    @Override
    protected String noBuildingFlavor() {
        return "The lake is calm, with only the sound of water lapping at the shore.";
    }
}