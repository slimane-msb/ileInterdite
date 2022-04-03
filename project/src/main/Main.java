package main;

import Models.game.Ile.Island;
import Views.Fenetre;
import Views.VueIle;
import Views.ZoneCliquable;

public class Main {
    public static void main(String[] args) {
        int nb = 8;
        Fenetre fenetre = new Fenetre(nb + "ile interdite");
        Island island = new Island(nb);
        Validation validation = new Validation(island);
        Indice indice = new Indice(island);
        fenetre.ajouteElement(new VueIle(island));
        fenetre.ajouteElement(validation);
        fenetre.ajouteElement(indice);
        fenetre.dessineFenetre();
    }
}




class Validation extends ZoneCliquable {

    private Island island;

    public Validation(Island island) {
        super("Valider", 80, 25);
        this.island = island;
    }


    public void clicGauche() {}

    public void clicDroit() {}
}

/*

  purpose of the button

*/

class Indice extends ZoneCliquable {

    private Island island;

    public Indice(Island p) {
        super("Indice", 80, 25);
        this.island = p;
    }

    public void clicGauche() {}

    public void clicDroit() {}
}



