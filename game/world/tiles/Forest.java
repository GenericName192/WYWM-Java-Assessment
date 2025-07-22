package game.world.tiles;
import game.buildings.BuildingType;
import java.util.List;

public class Forest extends Tile{

    /**
     * Constructor for Forest tile.
     * Initializes the tile with its terrain type and allowed building types.
     */
    public Forest() {
        super(TerrainType.FOREST, List.of(BuildingType.LUMBERMILL, BuildingType.SHOP));
        this.setTileName("Unnamed forest");
    }

    @Override
    String visitTile() {
        String tileName = this.getTileName();
        if (this.getCurrentBuildings().isEmpty()) {
            return """
            You find yourself in the dense forests of """
            + tileName + """
            , the canopy above filtering the sunlight. \
            The area is rich in resources, making it ideal for a lumbermill to harvest wood. \
            A shop could also serve those who venture into these woods.
            """;
        } else {
            return """
            You find yourself in the dense forests of """ + tileName + """
            , the canopy above filtering the sunlight. You approach """
            + this.getRandomBuilding().describe();
        }
    }
}
