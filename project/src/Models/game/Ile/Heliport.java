package Models.game.Ile;

import Models.game.Player.Artefact;
import Models.game.Player.Key;
import Models.game.Utils.Level;

public class Heliport extends Zone{

    public Heliport(Level state, Artefact artefactContained, Key key, Island island, Zone leftZone, Zone rightZone, Zone upperZone, Zone lowerZone) {
        super(state, artefactContained, key, island, leftZone, rightZone, upperZone, lowerZone);
    }

    public boolean isHasAllPlayers() {
        return this.getNbPlayers()==3;
    }



}
