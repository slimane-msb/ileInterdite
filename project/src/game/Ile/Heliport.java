package game.Ile;

import game.Player.Artefact;
import game.Utils.Level;

public class Heliport extends Zone{

    public Heliport(Level state, Artefact artefactContained, Ile ile, Zone leftZone, Zone rightZone, Zone upperZone, Zone lowerZone) {
        super(state, artefactContained, ile, leftZone, rightZone, upperZone, lowerZone);
    }

    public boolean isHasAllPlayers() {
        return this.getNbPlayers()==3;
    }



}
