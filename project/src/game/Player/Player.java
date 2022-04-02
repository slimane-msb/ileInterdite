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

    public boolean move(Direction direction){
        switch (direction) {
            case up:
                if(this.postion.getUpperZone().isSubmerged()){
                    this.postion=postion.getUpperZone();
                    return true;
                }else{
                    return false;
                }
            case down:
                this.postion=postion.getLowerZone();
                break;
            case right:
                this.postion=postion.getRightZone();
                break;
            case left:
                this.postion=postion.getLeftZone();
                break;
        }
        return true;
    }


}
