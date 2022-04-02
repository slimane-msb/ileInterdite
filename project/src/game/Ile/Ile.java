package game.Ile;

import game.Utils.Level;

import java.util.ArrayList;

public class Ile {
    private int length;
    private Zone[][] plateau;
    private boolean submerged;

    public Ile( int length, boolean submerged) {
        this.length=length;
        // construction of the island with submerged zones in the borders
        Level state;
        Zone left,right,up,down;
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                state = ( i==0 || j==0 || i==length-1|| j==length-1)?Level.submerged:Level.dry; // is in the borders
                up=(i==0)?null:plateau[i-1][j];
                down=(i==length-1)?null:plateau[i+1][j];
                left=(j==0)?null:plateau[i][j-1];
                right=(j==length-1)?null:plateau[i][j+1];
                this.plateau[i][j]=new Zone(state,null,null,this,left,right,up,down);
            }
        }

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
