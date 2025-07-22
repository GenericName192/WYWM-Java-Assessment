package game.buildings;

public class LumberMill extends Building {
    public LumberMill() {
        super(BuildingType.LUMBERMILL);
    }

    @Override
    String visitBuilding() {
        return "You are at the lumber mill, a place where trees are processed into timber. The air is filled with the sound of saws and the smell of fresh wood.";
    }

}
