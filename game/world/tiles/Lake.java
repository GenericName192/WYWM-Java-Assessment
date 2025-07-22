package game.world.tiles;
import game.buildings.BuildingType;
import java.util.List;

public class Lake extends Tile {
    public Lake() {
        super(TerrainType.LAKE, List.of(BuildingType.DOCK, BuildingType.SHOP));
        this.setTileName("Unnamed lake");
    }


    @Override
    String visitTile() {
        if (this.getCurrentBuildings().isEmpty()) {
            return """
            You find yourself in the tranquil waters of """
            + this.getTileName() + """
            , the surface shimmering under the sunlight. \
            The area is perfect for building a dock to facilitate trade or a shop \
            to cater to travelers and fishermen.
            """;
        } else {
            return """
            You find yourself by the tranquil waters of """ + this.getTileName() + """
            , gentle waves lapping at the shore. You approach """
            + this.getRandomBuilding().describe();
        }
    }
}