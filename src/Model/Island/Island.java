package Model.Island;

import Model.Player.Artefact;
import Model.Player.Key;
import Model.Player.Player;
import Model.Utils.ItemType;
import Model.Utils.Level;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Island {
    private float difficulty;
    private Random rand;
    private int length;
    private Zone[][] zones;
    private Zone helicop;
    private boolean submerged;
    private ArrayList<Key> keys;
    private ArrayList<Artefact> artefacts;
    private ArrayList<Player> players;


    public Island(int length) {
        this.length=length;
        this.difficulty = (float) 0.4;
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
        this.players.add(new Player(0, getZone(0, 0)));
        this.players.add(new Player(0, getZone(0, length-1)));
        this.players.add(new Player(0, getZone(length-1, 0)));
        this.players.add(new Player(0, getZone(length-1, length-1)));


        // adding key and artefact just for testing
        Key k = new Key(ItemType.air,this.players.get(0));
        Key t = new Key(ItemType.water,this.players.get(0));

        Key k2 = new Key(ItemType.air,this.players.get(2));
        Key t2 = new Key(ItemType.water,this.players.get(2));
        // end test

        this.submerged = false;

        this.keys = new ArrayList<Key>();
        this.keys.add(new Key(ItemType.air, null));
        this.keys.add(new Key(ItemType.earth, null));
        this.keys.add(new Key(ItemType.water, null));
        this.keys.add(new Key(ItemType.fire, null));

        this.artefacts = new ArrayList<Artefact>();
        createArtefact(ItemType.air);
        createArtefact(ItemType.earth);
        createArtefact(ItemType.water);
        createArtefact(ItemType.fire);

        // choosing the fisrt zone as helicop
        createHelicop();

    }

    public void createHelicop(){
        this.rand = new Random();
        int i = rand.nextInt(6);
        int j = rand.nextInt(6);
        this.setHelicop(this.getZone(i, j));
    }

    public void setHelicop(Zone helicop) {
        this.helicop = helicop;
    }

    public void createArtefact(ItemType type){
        Artefact a = new Artefact(type, false);
        this.getArtefacts().add(a);
        this.rand = new Random();
        int i = rand.nextInt(6);
        int j = rand.nextInt(6);

        this.getZone(i, j).setArtefact(a);
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

    public void setDifficulty(float difficulty) {
        this.difficulty = difficulty;
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

    public boolean isGameOver() {
        if (this.isSubmerged()){
            return true;
        }
        return false;
    }

    public boolean isWinning() {
        for (Artefact artefact : this.getArtefacts()) {
            if (!artefact.isFound()) {
                return false;
            }
        }
        for (Player player : this.getPlayers()){
            if(player.getPostion() != this.getHelicop()){
                return false;
            }
        }
        return true;
    }


    // players getters setters

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(int index){
        return this.getPlayers().get(index);
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

    public ArrayList<Artefact> getArtefacts() { return artefacts; }

    public Zone getHelicop() { return helicop; }

    // enf of class
}
