package game.world.tiles;
import game.buildings.BuildingType;
import java.util.List;

public class Plain extends Tile {
    public Plain() {
        super(TerrainType.PLAINS, List.of(BuildingType.FARM, BuildingType.SHOP));
    }
}
