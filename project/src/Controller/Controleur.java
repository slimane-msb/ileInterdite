package Controller;

import Model.Island.Island;
import View.Button.EndRound;
import View.Button.SearchKey;
import View.Button.ToDry;
import View.ViewGame.ViewIsland;
import View.ViewUtil.Window;

public class Controleur {

    private int length;
    private Window window;
    private Island island;
    private SearchKey searchKey;
    private EndRound endRound;
    private ToDry toDry;

    public Controleur( Island island) {
        this.length=island.getLength();
        this.window = new Window(island.getLength() + "ile interdite");
        this.island = island;
        this.searchKey = new SearchKey();
        this.toDry = new ToDry();
        this.endRound = new EndRound();
        window.ajouteElement(new ViewIsland(island.getLength()));
        window.ajouteElement(endRound);
//        window.ajouteElement(searchKey);
//        window.ajouteElement(toDry);
        window.dessineFenetre();
    }



}



