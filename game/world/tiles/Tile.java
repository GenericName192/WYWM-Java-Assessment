package game.world.tiles;
import java.util.ArrayList;
import java.util.List;
import game.buildings.Building;
import game.buildings.BuildingType;

public abstract class Tile {

    private TerrainType terrainType;
    private List<Building> currentBuildings = new ArrayList<>();
    private List<BuildingType> allowedBuildingTypes;

    public Tile(TerrainType terrainType, List<BuildingType> allowedBuildingTypes) {
        if (allowedBuildingTypes == null) {
        throw new IllegalArgumentException("allowedBuildingTypes cannot be null");
    }
        this.terrainType = terrainType;
        this.allowedBuildingTypes = List.copyOf(allowedBuildingTypes);
    }

    public TerrainType getTerrainType() {
        return terrainType;
    }

    public String toString() {
        return terrainType.toString();
    }

    public List<Building> getCurrentBuildings() {
        return currentBuildings;
    }

    public String getCurrentBuildingsAsString() {
    return currentBuildings.isEmpty()
        ? "No buildings here."
        : "Buildings: " + currentBuildings;
    }

    public List<BuildingType> getAllowedBuildings() {
        return allowedBuildingTypes;
    }

/**
 * Adds a building to the tile.
 * @param building The building to add.
 * @return true if the building was added, false if not allowed.
 */
    public boolean addBuilding(Building building) {
        if (building == null) {
        throw new IllegalArgumentException("Building cannot be null");
        }
        if (allowedBuildingTypes.contains(building.getType())) {
            currentBuildings.add(building);
            return true;
        } else {
            return false;
        }
    }
}
