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
     * Provides the base description of the tile (unique to each tile type).
     */
    protected abstract String baseDescription();

    /**
     * Provides the description shown when there are no buildings on the tile.
     */
    protected abstract String noBuildingFlavor();


    /**
     * Constructor for Tile.
     * @param terrainType The type of terrain for this tile.
     * @param allowedBuildingTypes The list of building types allowed on this tile.
     */
    public Tile(TerrainType terrainType, List<BuildingType> allowedBuildingTypes, String defaultName) {
        if (allowedBuildingTypes == null) {
        throw new IllegalArgumentException("allowedBuildingTypes cannot be null");
    }
        this.terrainType = terrainType;
        this.allowedBuildingTypes = List.copyOf(allowedBuildingTypes);
        this.tileName = defaultName;
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
     * @void doesn't return anything
     * @throws IllegalArgumentException if building is null
     */
    public void addBuilding(Building building) {
        if (building == null) {
        throw new IllegalArgumentException("Building cannot be null");
        }
        if (allowedBuildingTypes.contains(building.getBuildingType())) {
            currentBuildings.add(building);
            System.out.println("Building added: " + building.getBuildingType());
        } else {
            System.out.println("Building not allowed: " + building.getBuildingType() + " on " + terrainType);
        }
    }

    public Building getRandomBuilding() {
        if (currentBuildings.isEmpty()) return null;
        Building randomBuilding = currentBuildings.get(rand.nextInt(currentBuildings.size()));
        return randomBuilding;
    }

        public String visitTile() {
        String tileName = getTileName();

        if (currentBuildings.isEmpty()) {
            return String.format("""
                You are at %s. %s
                %s
                """, tileName, baseDescription(), noBuildingFlavor());
        } else {
            return String.format("""
                You are at %s. %s
                You approach %s.
                """, tileName, baseDescription(), getRandomBuilding().describe());
        }
    }
}
