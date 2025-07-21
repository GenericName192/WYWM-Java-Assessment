package game.world.tiles;
import game.buildings.BuildingType;
import java.util.List;

public class Forest extends Tile{
    public Forest() {
        super(TerrainType.FOREST, List.of(BuildingType.LUMBERMILL, BuildingType.SHOP));
    }
}
