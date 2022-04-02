package game.Ile;

import game.Player.Artefacts;
import game.Player.Player;
import game.Utils.Level;

import java.util.ArrayList;

public class Zone {
   // attributes
    private Level state;
    private Artefacts artefactContained; // null if it does not
    private Ile ile;
    private ArrayList<Player> players; // max 4
    private Zone leftZone;
    private Zone RightZone;
    private Zone upperZone;
    private Zone lowerZone;


    public Zone(Level state, Artefacts artefactContained, Ile ile,  Zone leftZone, Zone rightZone, Zone upperZone, Zone lowerZone) {
        this.state = state;
        this.artefactContained = artefactContained;
        this.ile = ile;
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

    public Artefacts getArtefactContained() {
        return artefactContained;
    }

    public void setArtefactContained(Artefacts artefactContained) {
        this.artefactContained = artefactContained;
    }

    public Ile getIle() {
        return ile;
    }

    public void setIle(Ile ile) {
        this.ile = ile;
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
                ", artefactContained=" + artefactContained +
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
     * make the zone dry
     */
    public void dry() {
        this.state=Level.dry;
    }

    /**
     * make the zone submerged
     */
    public void submerge() {
        this.state=Level.dry;
    }

    /**
     * make the zone flooded
     */
    public void flood() {
        this.state=Level.dry;
    }
}
