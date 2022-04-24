package Model.Player;

import Model.Island.Zone;
import Model.Utils.ItemType;

public abstract class Item {

    private ItemType itemType;

    public Item(ItemType itemType) {
        this.itemType = itemType;
    }


    @Override
    public String toString() {
        return "Item{" +
                "itemType=" + itemType ;
    }


    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }


}
