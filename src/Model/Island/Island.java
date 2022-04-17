package Model.Island;

import Model.Utils.Level;

import java.util.Random;

public class Island {
    private int length;
    private Zone[][] zones;
    private boolean submerged;

    public Island(int length) {
        this.length=length;
        this.zones=new Zone[length][length];
        // construction of the island with submerged zones in the borders
        Level state;
        Zone left,right,up,down;
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                state = ( i==0 || j==0 || i==length-1|| j==length-1)?Level.submerged:Level.dry; // is in the borders
                up=(i==0)?null: zones[i-1][j];
                down=(i==length-1)?null: zones[i+1][j];
                left=(j==0)?null: zones[i][j-1];
                right=(j==length-1)?null: zones[i][j+1];
                this.zones[i][j]=new Zone(state,null,null,this,left,right,up,down);
            }
        }

        this.submerged = false;
    }

    @Override
    public String toString() {
        return "Ile{" +
                "plateau=" + zones +
                ", submerged=" + submerged +
                '}';
    }

    public Zone[][] getGrille() {
        return zones;
    }

    /**
     *
     * @return true if all the island (all zones) are submerged
     */
    public boolean isSubmerged() {
        for (int i=0;i<length;i++){
            for (int j=0;i<length;j++){
                if(!zones[i][j].isSubmerged()) return false;
            }
        }
        return true;
    }


    /**
     *  submerge 3 random zones NOT  already submerged
     * @return @return array of 3 int corresponding to the number of the  submerged zones as (width*i+j)
     */
    public int[][] submerge3NotSubmergedZones(){
        int i,j;
        int[][] zonesNb = new int[3][2];
        Random rand = new Random();
        for (int k=0;k<3;k++) {
            i = rand.nextInt(length);
            j = rand.nextInt(length);
            while (this.zones[i][j].isSubmerged()) {
                i = rand.nextInt(length);
                j = rand.nextInt(length);
            }
            this.zones[i][j].submerge();
            zonesNb[k][0]= i;
            zonesNb[k][1]= j;
        }
        return zonesNb;
    }

    public int getLength() {
        return this.length;
    }

    public Zone getZone(int i, int j) {
        return this.zones[i][j];
    }

    // enf of class
}
