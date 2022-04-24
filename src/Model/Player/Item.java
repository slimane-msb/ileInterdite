package Model.Player;

import Model.Island.Zone;
import Model.Utils.ItemType;

public abstract class Item {

    private ItemType itemType;
    private Zone postion;

    public Item(ItemType itemType) {
        this.itemType = itemType;
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
