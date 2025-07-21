package game.world.tiles;
import game.buildings.BuildingType;
import java.util.List;

public class Lake extends Tile {
    public Lake() {
        super(TerrainType.LAKE, List.of(BuildingType.DOCK, BuildingType.SHOP));
    }
}
