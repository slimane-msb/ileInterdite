package game.Ile;

import game.Player.Artefacts;
import game.Player.Player;

import java.util.ArrayList;

public class Heliport extends Zone{

    public Heliport(Zone.Level state, Artefacts artefactContained, Ile ile, ArrayList<Player> players, Zone leftZone, Zone rightZone, Zone upperZone, Zone lowerZone) {
        super(state, artefactContained, ile, players, leftZone, rightZone, upperZone, lowerZone);
    }

    public boolean isHasAllPlayers() {
        return this.getNbPlayers()==3;
    }



}
