package game.world.tiles;
import game.buildings.BuildingType;
import java.util.List;

public class Plain extends Tile {
    public Plain() {
        super(TerrainType.PLAINS, List.of(BuildingType.FARM, BuildingType.SHOP), "Unnamed plain");
    }

    @Override
    protected String baseDescription() {
        return "A vast open plain with fertile soil, ideal for farming and grazing.";
    }

    @Override
    protected String noBuildingFlavor() {
        return "The plain is quiet, with only the sound of the wind rustling through the grass.";
    }
}
