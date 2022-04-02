package Models.game.Player;

import Models.game.Ile.Zone;
import Models.game.Utils.ItemType;


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

    public Artefact(ItemType itemType, Zone postion, boolean found) {
        super(itemType, postion);
        this.found = found;
    }
}
