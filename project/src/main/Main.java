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
        SearchKey searchKey = new SearchKey(island);
        ToDry indice = new ToDry(island);
        fenetre.ajouteElement(new VueIle(island));
        fenetre.ajouteElement(searchKey);
        fenetre.ajouteElement(indice);
        fenetre.dessineFenetre();
    }
}




class SearchKey extends ZoneCliquable {

    private Island island;

    public SearchKey(Island island) {
        super("searchKey", 80, 25);
        this.island = island;
    }


    public void clicGauche() {}

    public void clicDroit() {}
}

/*

  purpose of the button

*/

class ToDry extends ZoneCliquable {

    private Island island;

    public ToDry(Island p) {
        super("toDry", 80, 25);
        this.island = p;
    }

    public void clicGauche() {}

    public void clicDroit() {}
}



