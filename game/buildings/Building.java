package game.buildings;
import game.npc.Npc;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Building {
    private BuildingType buildingType;
    private List<Npc> workers = new ArrayList<>();
    private String buildingName;
    private static final Random rand = new Random();

    /**
     * Abstract method to be implemented by subclasses to describe the building.
     * @return A string description of the building.
     */
    abstract String visitBuilding();

    /**
     * Constructor for Building.
     * @param buildingType The type of building.
     */
    public Building(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public List<Npc> getWorkers() {
        return workers;
    }

    public String getBuildingName() {
        return buildingName;
    }

    /**
     * Gets a random worker's name from the building.
     * @return The name of a random worker, or null if there are no workers.
     */
    public String getRandomWorkerName() {
        if (workers.isEmpty()) return null;
        Npc randomWorker = workers.get(rand.nextInt(workers.size()));
        return randomWorker.getName();
    }

    /**
     * Describes the building.
     * @return A string description of the building and its workers.
     */
    public String describe() {
        if (workers.isEmpty()) {
            return buildingName + "it is empty and silent.";
        } else {
            String randomWorker = getRandomWorkerName();
            return buildingName + "it is busy with " + workers.size() + " workers. "
                 + randomWorker + " seems hard at work.";
        }
    }

/**
 * sets the buildings name.
 * @param buildingName The name to set for the building.
 * @void doesnt return anything
 * @throws IllegalArgumentException if buildingName is null or blank
 */
    public void setBuildingName(String buildingName) {
        if (buildingName == null || buildingName.isBlank()) {
            throw new IllegalArgumentException("Building name cannot be null or blank");
        }
        this.buildingName = buildingName;
    }



/**
 * Adds a worker to the building.
 * @param worker The worker to add.
 * @void doesnt return anything
 * @throws IllegalArgumentException if worker is null
 */
    public void addWorkers(Npc worker) {
        if (worker == null) {
            throw new IllegalArgumentException("worker cannot be null");
        } else {
            this.workers.add(worker);
        }
    }

/**
 * Removes a worker from the building.
 * @param worker The worker to remove.
 * @void doesnt return anything
 * @throws IllegalArgumentException if worker is null
 */
    public void removeWorker(Npc worker) {
        if (worker == null) {
            throw new IllegalArgumentException("worker cannot be null");
        } else {
            this.workers.remove(worker);
        }
    }

/**
 * Adds a worker from one building to another building.
 * @param worker The worker to move.
 * @param newBuilding The building to move the worker to.
 * @void doesnt return anything
 * @throws IllegalArgumentException if worker or the building is null
 */
    public void moveWorker(Npc worker, Building newBuilding) {
        if (worker == null || newBuilding == null) {
            throw new IllegalArgumentException("worker and new building cannot be null");
        }
        removeWorker(worker);
        newBuilding.addWorkers(worker);
    }
}