package game.buildings;

public class Dock extends Building {
    public Dock() {
        super(BuildingType.DOCK);
    }

    @Override
    public String visitBuilding() {
        return "You are at the dock, a bustling hub of trade and travel. Ships come and go, bringing goods from distant lands. The salty air is filled with the sounds of seagulls and the creaking of wooden ships.";
    }

}
