package game.Ile;

import game.Player.Artefact;
import game.Player.Key;
import game.Utils.Level;

public class Heliport extends Zone{

    public Heliport(Level state, Artefact artefactContained, Key key, Island island, Zone leftZone, Zone rightZone, Zone upperZone, Zone lowerZone) {
        super(state, artefactContained, key, island, leftZone, rightZone, upperZone, lowerZone);
    }

    public boolean isHasAllPlayers() {
        return this.getNbPlayers()==3;
    }



}
