package Model.Player;

import Model.Island.Zone;
import Model.Utils.ItemType;


public class Artefact extends  Item {
    private boolean found;

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

    public Artefact(ItemType itemType, boolean found) {
        super(itemType);
        this.found = found;
    }
}
