package Model.Player;

import Model.Island.Zone;
import Model.Utils.ItemType;


public class Artefact extends  Item {
    private boolean found;
    private Zone position;

    @Override
    public String toString() {
        return "Artefacts{" +
                "found=" + found +
                '}';
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public Artefact(ItemType itemType, boolean found, Zone position) {
        super(itemType);
        this.found = found;
        this.position = position;
    }


    public Zone getPosition() {
        return  this.position;
    }
}
