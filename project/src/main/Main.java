package main;

import Model.Island.Island;
import View.*;
import View.Command.SearchKey;
import View.Command.ToDry;

public class Main {
    public static void main(String[] args) {
        int nb = 8;
        Window window = new Window(nb + "ile interdite");
        Island island = new Island(nb);
        SearchKey searchKey = new SearchKey();
        ToDry indice = new ToDry();
        window.ajouteElement(new ViewIsland(island.getLength()));
        //fenetre.ajouteElement(searchKey);
       // fenetre.ajouteElement(indice);
        window.dessineFenetre();
    }
}






