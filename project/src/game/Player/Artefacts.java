package game.Player;

import game.Ile.Zone;
import game.Utils.ItemType;


public class Artefacts extends  Item {
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

    public Artefacts(ItemType itemType, Zone postion, boolean found) {
        super(itemType, postion);
        this.found = found;
    }
}
