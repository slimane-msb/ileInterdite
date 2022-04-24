package Model.Island;

import Model.Player.Key;
import Model.Player.Player;
import Model.Utils.ItemType;
import Model.Utils.Level;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Island {
    private float difficulty;
    private int length;
    private Zone[][] zones;
    private Zone helicop;
    private boolean submerged;
    private ArrayList<Key> keys;
    private ArrayList<Player> players;


    public Island(int length, float difficulty) {
        this.length=length;
        this.difficulty = difficulty;
        this.zones = new Zone[length][length];
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
        this.players = new ArrayList<Player>();
        // construction of players
        for (int i=0;i<4;i++){
            this.addPlayer(new Player(i,helicop));
        }

        // choosing the fisrt zone as helicop
        this.helicop=zones[0][0];

        this.submerged = false;

        this.keys = new ArrayList<Key>();
        this.keys.add(new Key(ItemType.air, null));
        this.keys.add(new Key(ItemType.earth, null));
        this.keys.add(new Key(ItemType.water, null));
        this.keys.add(new Key(ItemType.fire, null));
    }

    @Override
    public String toString() {
        String zonesstr="";
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                zonesstr+=i+j+":"+this.zones[i][j].toString()+"\n";
            }
        }
        return "Ile{" +
                "plateau=" + zonesstr +
                ", submerged=" + submerged +
                '}';
    }

    public Zone[][] getGrille() {
        return zones;
    }

    public float getDifficulty(){
        return this.difficulty;
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
     * @return @return array of 3 int corresponding to the number of the  submerged zones as [i,j]
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

    public ArrayList<Key> getKeys(){
        return this.keys;
    }
    public void removeKey(int index){
        for(int i = 0; i < this.keys.size(); i++) {
            if(i == index){
                this.keys.remove(this.keys.get(index));

            }
        }
    }

    // players getters setters

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * add a player to the list of players on the island
     * @param player
     */
    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(Player player){
        this.players.remove(player);
    }


    public boolean isGameOver() {
        // TO-DO
        return false;
    }


    // enf of class
}
