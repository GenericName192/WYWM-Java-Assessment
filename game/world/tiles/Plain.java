package game.world.tiles;
import game.buildings.BuildingType;
import java.util.List;

public class Plain extends Tile {
    public Plain() {
        super(TerrainType.PLAINS, List.of(BuildingType.FARM, BuildingType.SHOP));
        this.setTileName("Unnamed plain");
    }

    @Override
    String visitTile() {
        String tileName = this.getTileName();
        if (this.getCurrentBuildings().isEmpty()) {
            return """
            You stand amidst the open expanse of """
            + tileName + """
            , where tall grasses sway in the gentle breeze. \
            The fertile land is ideal for establishing a farm or setting up a shop \
            to serve passing travelers and local farmers.
            """;
        } else {
            return """
            You walk through the vast plains of """ + tileName + """
            , where tall grasses sway in the gentle breeze. You approach """
            + this.getRandomBuilding().describe();
        }
    }
}
