package Model.Player;

import Model.Island.Zone;
import Model.Utils.Direction;
import Model.Utils.ItemType;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import java.util.ArrayList;

public class Player {
    // attributes
    private int playerNb;
    private Zone postion;
    private ArrayList<Key> keys;
    private ArrayList<Artefact> artefacts;

    // number of actions left is set in the Models.game class and controlled by controller


    @Override
    public String toString() {
        return "Joueur{" +
                "playerNb=" + playerNb +
                ", postion=" + postion +
                '}';
    }

    public Player(int playerNb, Zone postion) {
        this.playerNb = playerNb;
        this.postion = postion;
        this.keys = new ArrayList<Key>();
        this.artefacts=new ArrayList<Artefact>();
    }

    public int getPlayerNb() {
        return playerNb;
    }

    public Zone getPostion() {
        return postion;
    }



    public void setPlayerNb(int playerNb) {
        this.playerNb = playerNb;
    }

    public void setPostion(Zone postion) {
        this.postion = postion;
    }

    /**
     *
     * @param direction take direction(up,left,down,right) and move the player to this corresponding zone if this last is not submerged
     * @return true if the player has moved, false if not
         * @Note: that the number of action is not decreased, this number is managed by the controller
     */
    public boolean move(Direction direction){
        switch (direction) {
            case up:
                System.out.println(this.postion.getUpperZone().isSubmerged());
                if (this.postion.getUpperZone() == null || this.postion.getUpperZone().isSubmerged()){
                    return false;
                }else{
                    this.postion=postion.getUpperZone();
                    return true;
                }
            case down:
                if(this.postion.getLowerZone() == null || this.postion.getLowerZone().isSubmerged()){
                    return false;
                }else{
                    this.postion=postion.getLowerZone();
                    return true;
                }
            case right:
                if(this.postion.getRightZone() == null || this.postion.getRightZone().isSubmerged()){
                    return false;
                }else {
                    this.postion=postion.getRightZone();
                    return true;
                }
            case left:
                if(this.postion.getLeftZone() == null || this.postion.getLeftZone().isSubmerged()){
                    return false;
                }else{
                    this.postion=postion.getLeftZone();
                    return true;
                }
        }
        return false;
    }

    /**
     *
     * @param direction take direction(up,left,down,right) and try to dry the corresponding zone if this last is not submerged or already dry
     * @return true if action (to dry) is taken, and false if not
     */
    public boolean toDry(Direction direction){
        switch (direction) {
            case up:
                return this.postion.getUpperZone().decreaseWaterLevel();
            case down:
                return this.postion.getLowerZone().decreaseWaterLevel();
            case right:
                return this.postion.getRightZone().decreaseWaterLevel();
            case left:
                return this.postion.getLeftZone().decreaseWaterLevel();
            case same:
                return this.postion.decreaseWaterLevel();
        }
        return false;
    }


    /**
     *
     * @return true if the player took the artefact found in his current zone by having the corresponding key to this artefact, false if not
     */
    public boolean takeArtefact(){
        if (this.postion.containsArtefact()){
            if(this.hasKey(this.postion.getArtefact().getItemType())){
                this.artefacts.add(this.postion.getArtefact());
                this.postion.setArtefact(null);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param itemType (air, fire,water,lan) as ItemType.air
     * @return true if the player has a key coressponding to this type of item, false if not
     */
    public boolean hasKey(ItemType itemType) {
        for (Key key : this.keys){
            if(key.getItemType()==itemType) return true;
        }
        return false;
    }

    /**
     * search for a key in the current zone, increase water level if any key is not found
     * @return true if key is found, false if not
     */
    public boolean searchKey(){
        float difficulty = this.postion.getIle().getDifficulty();
        ArrayList<Key> keysNotFound = this.postion.getIle().getKeys();
        Random randomGenerator = new Random();

        if(keysNotFound.isEmpty()){
            return false;
        }

        if(randomGenerator.nextFloat() <= difficulty){
            int keyIndex = randomGenerator.nextInt(keysNotFound.size());
            this.keys.add(keysNotFound.get(keyIndex));
            this.postion.getIle().removeKey(keyIndex);
            return true;
        }
        return false;
    }

    public ArrayList<Key> getKeys() {
        return this.keys;
    }

    public void setKeys(ArrayList<Key> keys) {
        this.keys = keys;
    }

    public ArrayList<Artefact> getArtefacts() {
        return artefacts;
    }

    public void setArtefacts(ArrayList<Artefact> artefacts) {
        this.artefacts = artefacts;
    }

    // end of class
}
