package Model.Island;

import Model.Player.Artefact;
import Model.Player.Key;
import Model.Player.Player;
import Model.Utils.Direction;
import Model.Utils.ItemType;
import Model.Utils.Level;

import java.util.ArrayList;
import java.util.Random;

public class Island {
    private float difficulty;
    private Random rand;
    private int length;
    private Zone[][] zones;
    private Zone helicop;
    private ArrayList<Key> keys;
    private ArrayList<Artefact> artefacts;
    private ArrayList<Player> players;


    public Island(int length) {
        this.length=length;
        this.difficulty = (float) 0.75;
        this.zones = new Zone[length][length];
        // construction of the island with submerged zones in the borders
        Zone left,right,up,down;
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                this.zones[i][j]=new Zone(Level.dry,null,null,this,null,null,null,null);
                this.zones[i][j].setX(i);
                this.zones[i][j].setY(j);
            }
        }
        // set neighbors
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                up=(j==0)?null: zones[i][j-1];
                down=(j==length-1)?null: zones[i][j+1];
                left=(i==0)?null: zones[i-1][j];
                right=(i==length-1)?null: zones[i+1][j];
                this.zones[i][j].setUpperZone(up);
                this.zones[i][j].setLeftZone(left);
                this.zones[i][j].setRightZone(right);
                this.zones[i][j].setLowerZone(down);
            }

        }





        this.players = new ArrayList<Player>();
        this.players.add(new Player(0, getZone(0, 0)));
        this.players.add(new Player(0, getZone(0, length-1)));
        this.players.add(new Player(0, getZone(length-1, 0)));
        this.players.add(new Player(0, getZone(length-1, length-1)));



        this.keys = new ArrayList<Key>();
        this.keys.add(new Key(ItemType.air, null));
        this.keys.add(new Key(ItemType.earth, null));
        this.keys.add(new Key(ItemType.water, null));
        this.keys.add(new Key(ItemType.fire, null));

        this.artefacts = new ArrayList<Artefact>();
        addArtefact(ItemType.air);
        addArtefact(ItemType.earth);
        addArtefact(ItemType.water);
        addArtefact(ItemType.fire);

        // choosing the fisrt zone as helicop
        createHelicop();

    }

    public void createHelicop(){
        this.rand = new Random();
        int i = rand.nextInt(length);
        int j = rand.nextInt(length);
        this.setHelicop(this.getZone(i, j));
    }

    public void setHelicop(Zone helicop) {
        this.helicop = helicop;
    }

    public void addArtefact(ItemType type){
        this.rand = new Random();
        int i,j;
        do {
            i = rand.nextInt(this.length - 1);
            j = rand.nextInt(this.length - 1);
        }while(this.getZone(i,j).containsArtefact());
        Artefact a = new Artefact(type, false,this.getZone(i,j));
        this.getArtefacts().add(a);
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
        int nbCaseSubmerged = 0;
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                if(zones[i][j].isSubmerged()) nbCaseSubmerged++ ;
            }
        }
        return (nbCaseSubmerged >= (length*length - 1)); //s'il ne reste qu'une seule case, alors l'île est submergée
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
            this.zones[i][j].increaseWaterLevel();
            ArrayList<Direction> dirs = new ArrayList<>();
            dirs.add(Direction.up);
            dirs.add(Direction.down);
            dirs.add(Direction.left);
            dirs.add(Direction.right);
            Random random = new Random();
            for (Player player: this.players){
                while (player.getPosition().isSubmerged() && dirs.size()>0) {
                    int rnd = random.nextInt(dirs.size());
                    player.move(dirs.get(rnd));
                    dirs.remove(dirs.get(rnd));
                }
            }
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
        for (Player player : this.players){
            if ( player.isBlocked()) return  true;
        }
        if (this.isSubmerged()  || this.getHelicop().isSubmerged() ){
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
            if(player.getPosition() != this.getHelicop()){
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

    public Artefact getAir(){
        return this.artefacts.get(0);
    }

    public Artefact getLand(){
        return this.artefacts.get(1);
    }
    public Artefact getWater(){
        return this.artefacts.get(2);
    }
    public Artefact getFire(){
        return this.artefacts.get(3);
    }
    public Zone getHelicop() { return helicop; }

    // enf of class
}
