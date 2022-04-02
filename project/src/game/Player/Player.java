package game.Player;

import game.Ile.Zone;
import game.Utils.Direction;
import game.Utils.ItemType;

import java.util.ArrayList;

public class Player {
    // attributes
    private int playerNb;
    private Zone postion;
    private ArrayList<Key> keys;
    private ArrayList<Artefact> artefacts;

    // number of actions left is set in the game class and controlled by controller


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
                if(!this.postion.getUpperZone().isSubmerged()){
                    this.postion.removePlayer(this);
                    this.postion=postion.getUpperZone();
                    this.postion.addPlayer(this);
                    return true;
                }else{
                    return false;
                }
            case down:
                if(!this.postion.getLowerZone().isSubmerged()){
                    this.postion.removePlayer(this);
                    this.postion=postion.getLowerZone();
                    this.postion.addPlayer(this);
                    return true;
                }else{
                    return false;
                }
            case right:
                if(!this.postion.getRightZone().isSubmerged()){
                    this.postion.removePlayer(this);
                    this.postion=postion.getRightZone();
                    this.postion.addPlayer(this);
                    return true;
                }else {
                    return false;
                }
            case left:
                if(!this.postion.getLeftZone().isSubmerged()){
                    this.postion.removePlayer(this);
                    this.postion=postion.getLeftZone();
                    this.postion.addPlayer(this);
                    return true;
                }else{
                    return false;
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
                switch (this.postion.getUpperZone().getState()){
                    case dry: case submerged: // action  to dry is not allowed si zone is either dry or submerged
                        return false;
                    case flooded:
                        this.postion.getUpperZone().dry();
                        return false;
                }

            case down:
                switch (this.postion.getLowerZone().getState()){
                    case dry: case submerged: // action  to dry is not allowed si zone is either dry or submerged
                        return false;
                    case flooded:
                        this.postion.getUpperZone().dry();
                        return false;
                }
            case right:
                switch (this.postion.getRightZone().getState()){
                    case dry: case submerged: // action  to dry is not allowed si zone is either dry or submerged
                        return false;
                    case flooded:
                        this.postion.getUpperZone().dry();
                        return false;
                }
            case left:
                switch (this.postion.getLeftZone().getState()){
                    case dry: case submerged: // action  to dry is not allowed si zone is either dry or submerged
                        return false;
                    case flooded:
                        this.postion.getUpperZone().dry();
                        return false;
                }
        }
        return false;
    }


    /**
     *
     * @return true if the player took the artefact found in his current zone by having the corresponding key to this artefact, false if not
     */
    public boolean takeArtefacte(){
        if (this.postion.containsArtefact()){
            if(this.hasKey(this.postion.getArtefact().getItemType())){
                this.artefacts.add(this.postion.getArtefact());
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
    private boolean hasKey(ItemType itemType) {
        for (Key key : this.keys){
            if(key.getItemType()==itemType) return true;
        }
        return false;
    }


    // end of class
}
