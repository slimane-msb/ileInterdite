package Model.Player;

import Model.Island.Zone;
import Model.Utils.ItemType;

public class Key extends  Item{
    private boolean possessed;
    private  Player player;

    public Key(ItemType itemType, Zone postion, boolean possessed, Player player) {
        super(itemType, postion);
        this.possessed = possessed;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Keys{" +
                "found=" + possessed +
                '}';
    }

    /**
     *
     * @return true if it belogs to someone
     */
    public boolean isPossessed() {
        return player!=null;
    }


}
