package Model.Player;

import Model.Island.Zone;
import Model.Utils.Direction;
import Model.Utils.ItemType;

import java.util.Random;

import java.util.ArrayList;

public class Player {
    // attributes
    private int playerNb;
    private Zone position;
    private ArrayList<Key> keys;
    private ArrayList<Artefact> artefacts;

    // number of actions left is set in the Models.game class and controlled by controller


    @Override
    public String toString() {
        return "Joueur{" +
                "playerNb=" + playerNb +
                ", postion=" + position +
                '}';
    }

    public Player(int playerNb, Zone postion) {
        this.playerNb = playerNb;
        this.position = postion;
        this.keys = new ArrayList<Key>();
        this.artefacts=new ArrayList<Artefact>();
    }

    public int getPlayerNb() {
        return playerNb;
    }

    public Zone getPosition() {
        return position;
    }



    public void setPlayerNb(int playerNb) {
        this.playerNb = playerNb;
    }

    public void setPosition(Zone position) {
        this.position = position;
    }

    /**
     *
     * @param direction take direction(up,left,down,right) and move the player to this corresponding zone if this last is not submerged
     * @return true if the player has moved, false if not
         * @Note: that the number of action is not decreased, this number is managed by the controller
     */
    public boolean move(Direction direction){
        System.out.println("player ---> "+this.position);
        switch (direction) {
            case up:
                System.out.println(""+this.position.getUpperZone().getState());
                if (this.position.getUpperZone() == null || this.position.getUpperZone().isSubmerged()){
                    return false;
                }else{
                    this.position = position.getUpperZone();
                    return true;
                }
            case down:
                System.out.println(""+this.position.getLowerZone().getState());
                if(this.position.getLowerZone() == null || this.position.getLowerZone().isSubmerged()){
                    return false;
                }else{
                    this.position = position.getLowerZone();
                    return true;
                }
            case right:
                if(this.position.getRightZone() == null || this.position.getRightZone().isSubmerged()){
                    return false;
                }else {
                    this.position = position.getRightZone();
                    return true;
                }
            case left:
                System.out.println(""+this.position.getLeftZone().getState());
                if(this.position.getLeftZone() == null || this.position.getLeftZone().isSubmerged()){
                    return false;
                }else{
                    this.position = position.getLeftZone();
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
                return this.position.getUpperZone().decreaseWaterLevel();
            case down:
                return this.position.getLowerZone().decreaseWaterLevel();
            case right:
                return this.position.getRightZone().decreaseWaterLevel();
            case left:
                return this.position.getLeftZone().decreaseWaterLevel();
            case same:
                return this.position.decreaseWaterLevel();
        }
        return false;
    }


    /**
     *
     * @return true if the player took the artefact found in his current zone by having the corresponding key to this artefact, false if not
     */
    public boolean takeArtefact(){
        if (this.position.containsArtefact()){
            if(this.hasKey(this.position.getArtefact().getItemType())){
                this.artefacts.add(this.position.getArtefact());
                this.position.setArtefact(null);
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
        float difficulty = this.position.getIle().getDifficulty();
        ArrayList<Key> keysNotFound = this.position.getIle().getKeys();
        Random randomGenerator = new Random();

        if(keysNotFound.isEmpty()){
            return false;
        }

        if(randomGenerator.nextFloat() <= difficulty){
            int keyIndex = randomGenerator.nextInt(keysNotFound.size());
            this.keys.add(keysNotFound.get(keyIndex));
            this.position.getIle().removeKey(keyIndex);
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

    public ArrayList<Zone> possibleNeighbors(){
        ArrayList<Zone> possN = new ArrayList<>();
        if (this.position.getLeftZone()!=null) possN.add(this.position.getLeftZone());
        if (this.position.getRightZone()!=null) possN.add(this.position.getRightZone());
        if (this.position.getUpperZone()!=null) possN.add(this.position.getUpperZone());
        if (this.position.getLowerZone()!=null) possN.add(this.position.getLowerZone());
        return  possN;
    }

    public boolean isBlocked() {
        for (Zone neighbor: this.possibleNeighbors()){
            if(!neighbor.isSubmerged()) return false;
        }
        return  true;
    }

    // end of class
}
