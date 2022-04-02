package game.Ile;

import game.Player.Artefact;
import game.Player.Key;
import game.Player.Player;
import game.Utils.Level;

import java.util.ArrayList;

public class Zone {
   // attributes
    private Level state;
    private Artefact artefact;
    private Key key;
    private Island island;
    private ArrayList<Player> players; // max 4
    private Zone leftZone;
    private Zone RightZone;
    private Zone upperZone;
    private Zone lowerZone;


    public Zone(Level state, Artefact artefactContained, Key key, Island island, Zone leftZone, Zone rightZone, Zone upperZone, Zone lowerZone) {
        this.state = state;
        this.artefact = artefactContained;
        this.key = key;
        this.island = island;
        this.players = new ArrayList<Player>();
        this.leftZone = leftZone;
        RightZone = rightZone;
        this.upperZone = upperZone;
        this.lowerZone = lowerZone;
    }

    public Level getState() {
        return state;
    }

    public void setState(Level state) {
        this.state = state;
    }

    public Artefact getArtefact() {
        return artefact;
    }

    public void setArtefact(Artefact artefact) {
        this.artefact = artefact;
    }

    public Island getIle() {
        return island;
    }

    public void setIle(Island island) {
        this.island = island;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     *
     * @return number of players on the zone
     */
    public int getNbPlayers() {
        return players.size();
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Zone getLeftZone() {
        return leftZone;
    }

    /**
     *
     * @return true is the zone is submerged
     */
    public boolean isSubmerged(){
        return this.state==Level.submerged;
    }

    /**
     *
     * @return true if the zone is flooded
     */
    public boolean isFlooded() {
        return this.state==Level.flooded;
    }

    /**
     *
     * @return true if the zone is dry
     */
    public boolean isDry() {
        return this.state==Level.dry;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "state=" + state +
                ", artefactContained=" + artefact +
                ", players=" + players +
                '}';
    }

    public void setLeftZone(Zone leftZone) {
        this.leftZone = leftZone;
    }

    public Zone getRightZone() {
        return RightZone;
    }

    public void setRightZone(Zone rightZone) {
        RightZone = rightZone;
    }

    public Zone getUpperZone() {
        return upperZone;
    }

    public void setUpperZone(Zone upperZone) {
        this.upperZone = upperZone;
    }

    public Zone getLowerZone() {
        return lowerZone;
    }

    public void setLowerZone(Zone lowerZone) {
        this.lowerZone = lowerZone;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    /**
     *
     * @param player add player to the list of player on the zone
     */
    public void addPlayer(Player player){
        this.players.add(player);
    }

    /**
     *
     * @param player remove the player from the list of players on the zobe
     */
    public void removePlayer(Player player){
        this.players.remove(player);
    }

    /**
     * if state is submerged nothing  has to be changed
     * @return true if the level has increased (zone state is changed), false if not
     */
    public boolean increaseWaterLevel(){
        switch(this.state){
            case dry:
                this.state=Level.flooded;
                return true;
            case flooded:
                this.state=Level.submerged;
                return true;
        }
        return false;
    }

    /**
     * if state is dry nothing has to be changed, if submerged state can not be changed
     * @return true if the level has decreased (zone state is changed), false if not
     */
    public boolean decreaseWaterLevel(){
        switch(this.state){
            case flooded:
                this.state=Level.dry;
                return true;
        }
        return false;
    }



    public boolean containsArtefact() {
        return this.artefact !=null;
    }

    public boolean containsKey() {
        return this.key!=null;
    }

    /**
     * submerge a zone
     */
    public void submerge() {
        this.state=Level.submerged;
    }
}
