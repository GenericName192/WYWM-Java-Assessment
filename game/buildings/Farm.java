package game.buildings;

public class Farm extends Building {
    public Farm() {
        super(BuildingType.FARM);
    }

    @Override
    public String visitBuilding() {
        return "You are at the farm, a lush expanse of fields and crops. The air is filled with the sounds of nature, and you can see farmers tending to the land.";
    }

}
