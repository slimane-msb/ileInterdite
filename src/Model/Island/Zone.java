package Model.Island;

import Model.Player.Artefact;
import Model.Player.Key;
import Model.Player.Player;
import Model.Utils.Level;

import java.util.ArrayList;

public class Zone {
   // attributes
    private Level state;
    private Artefact artefact;
    private Key key;
    private Island island;
    private Zone leftZone;
    private Zone rightZone;
    private Zone upperZone;
    private Zone lowerZone;


    public Zone(Level state, Artefact artefactContained, Key key, Island island, Zone leftZone, Zone rightZone, Zone upperZone, Zone lowerZone) {
        this.state = state;
        this.artefact = artefactContained;
        this.key = key;
        this.island = island;
        this.leftZone = leftZone;
        this.rightZone = rightZone;
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
                '}';
    }

    public void setLeftZone(Zone leftZone) {
        this.leftZone = leftZone;
    }

    public Zone getRightZone() {
        return rightZone;
    }

    public void setRightZone(Zone rightZone) {
        this.rightZone = rightZone;
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
