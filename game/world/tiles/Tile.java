package game.world.tiles;
import java.util.ArrayList;
import java.util.List;
import game.buildings.Building;
import game.buildings.BuildingType;
import java.util.Random;

public abstract class Tile {

    private TerrainType terrainType;
    private List<Building> currentBuildings = new ArrayList<>();
    private List<BuildingType> allowedBuildingTypes;
    private String tileName;
    private static final Random rand = new Random();

    /**
     * Abstract method to be implemented by subclasses to describe the tile.
     * @return A string description of "walking" around the tile.
     */
    abstract String visitTile();

    /**
     * Constructor for Tile.
     * @param terrainType The type of terrain for this tile.
     * @param allowedBuildingTypes The list of building types allowed on this tile.
     */
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

    /**
     * shows what buildings are on the tile as a string.
     * @return A string representation of the current buildings on the tile.
     */
    public String getCurrentBuildingsAsString() {
    return currentBuildings.isEmpty()
        ? "No buildings here."
        : "Buildings: " + currentBuildings;
    }

    public List<BuildingType> getAllowedBuildings() {
        return allowedBuildingTypes;
    }

    public String getTileName() {
        return tileName;
    }

    /**
     * sets the tile name.
     * @param tileName The name to set for the tile.
     * @void doesnt return anything
     * @throws IllegalArgumentException if tileName is null or blank
     */
    public void setTileName(String tileName) {
        if (tileName == null || tileName.isBlank()) {
            throw new IllegalArgumentException("Tile name cannot be null or blank");
        }
        this.tileName = tileName;
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
        if (allowedBuildingTypes.contains(building.getBuildingType())) {
            currentBuildings.add(building);
            return true;
        } else {
            return false;
        }
    }

    public Building getRandomBuilding() {
        if (currentBuildings.isEmpty()) return null;
        Building randomBuilding = currentBuildings.get(rand.nextInt(currentBuildings.size()));
        return randomBuilding;
    }
}
