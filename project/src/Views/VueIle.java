package Views;

import Models.game.Ile.Island;
import Models.game.Ile.Zone;
import Views.Grille;

public class VueIle  extends Grille {
    private Island island;
    // Constructeur
    public VueIle(Island island) {
        super(island.getLength(),island.getLength());
        this.island=island;
        for (int i = 0; i < island.getLength(); i++) {
            for (int j = 0; j < island.getLength(); j++) {
                this.ajouteElement( new VueZone("",i,j));
            }
        }
    }
}