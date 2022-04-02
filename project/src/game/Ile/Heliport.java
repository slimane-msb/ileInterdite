package game.Ile;

import game.Player.Artefacts;
import game.Player.Player;
import game.Utils.Level;

import java.util.ArrayList;

public class Heliport extends Zone{

    public Heliport(Level state, Artefacts artefactContained, Ile ile, Zone leftZone, Zone rightZone, Zone upperZone, Zone lowerZone) {
        super(state, artefactContained, ile, leftZone, rightZone, upperZone, lowerZone);
    }

    public boolean isHasAllPlayers() {
        return this.getNbPlayers()==3;
    }



}
