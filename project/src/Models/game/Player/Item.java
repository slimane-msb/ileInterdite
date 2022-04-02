package Models.game.Player;

import Models.game.Ile.Zone;
import Models.game.Utils.ItemType;

abstract class Item {

    private ItemType itemType;
    private Zone postion;

    public Item(ItemType itemType, Zone postion) {
        this.itemType = itemType;
        this.postion = postion;
    }


    @Override
    public String toString() {
        return "Item{" +
                "itemType=" + itemType +
                ", postion=" + postion +
                '}';
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Zone getPostion() {
        return postion;
    }

    public void setPostion(Zone postion) {
        this.postion = postion;
    }
}
