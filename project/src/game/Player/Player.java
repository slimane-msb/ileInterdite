package game.Player;

import game.Ile.Zone;
import game.Utils.Direction;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;

import static game.Utils.Direction.up;

public class Player {
    // attributes
    private int playerNb;
    private Zone postion;
    private ArrayList<Keys> keys;
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
        this.keys = new ArrayList<Keys>();
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

    




    // end of class
}
