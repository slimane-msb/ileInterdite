package game.Ile;

import java.util.ArrayList;

public class Ile {
    private ArrayList<Zone> grille;
    private boolean submerged;

    public Ile( boolean submerged) {
        this.grille = new ArrayList<Zone>() ;
        this.submerged = submerged;
    }

    @Override
    public String toString() {
        return "Ile{" +
                "grille=" + grille +
                ", submerged=" + submerged +
                '}';
    }

    public ArrayList<Zone> getGrille() {
        return grille;
    }

    public void setGrille(ArrayList<Zone> grille) {
        this.grille = grille;
    }

    public boolean isSubmerged() {
        return submerged;
    }

    public void setSubmerged(boolean submerged) {
        this.submerged = submerged;
    }
}
