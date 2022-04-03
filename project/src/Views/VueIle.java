package Views;

import Models.game.Ile.Island;
import Models.game.Ile.Zone;
import Views.Grille;

public class VueIle extends Island extends Grille {
    private Island island;
    // Constructeur
    public VueIle() {
        for (int i = 0; i < island.getLength(); i++) {
            for (int j = 0; j < island.getLength(); j++) {
                this.ajouteElement(island.getZone(i,j));
            }
        }
    }
}