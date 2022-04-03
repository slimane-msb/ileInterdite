package main;

import Model.Island.Island;
import Views.Window;
import Views.ViewIsland;
import Views.ViewCommand;

public class Main {
    public static void main(String[] args) {
        int nb = 8;
        Window window = new Window(nb + "ile interdite");
        Island island = new Island(nb);
        SearchKey searchKey = new SearchKey(island);
        ToDry indice = new ToDry(island);
        window.ajouteElement(new ViewIsland(island));
        //fenetre.ajouteElement(searchKey);
       // fenetre.ajouteElement(indice);
        window.dessineFenetre();
    }
}




class SearchKey extends ViewCommand {

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

class ToDry extends ViewCommand {

    private Island island;

    public ToDry(Island p) {
        super("toDry", 80, 25);
        this.island = p;
    }

    public void clicGauche() {}

    public void clicDroit() {}
}



