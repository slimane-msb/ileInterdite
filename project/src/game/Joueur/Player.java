package game.Joueur;

import game.Ile.Zone;

public class Player {
    // attributes
    private int playerNb;
    private Zone postion;
    // actions left is set in the game class and controlled by controller


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
}
