package Controller;

import Model.Island.Island;
import Model.Island.Zone;
import View.Button.EndRound;
import View.Button.SearchKey;
import View.Button.ToDry;
import View.ViewGame.ViewIsland;
import View.ViewUtil.Window;

public class Controller {

    private int length;
    private Window window;
    private Island island;
    private ViewIsland viewIsland;
    private SearchKey searchKey;
    private EndRound endRound;
    private ToDry toDry;

    public Controller(Island island) {
        this.length=island.getLength();
        this.window = new Window(island.getLength() + "ile interdite");
        this.island = island;
        this.searchKey = new SearchKey(this);
        this.toDry = new ToDry(this);
        this.endRound = new EndRound(this);
        this.viewIsland = new  ViewIsland(this,island.getLength());
        this.window.ajouteElement(viewIsland);
        this.window.ajouteElement(endRound);
//        this.window.ajouteElement(searchKey);
//        this.window.ajouteElement(toDry);
        this.window.dessineFenetre();
    }

    /**
     * get the number of the zone we need to submerge, and then call the methode submergeView to color ble
     */
//    public void endRoundClicked(){
//        int[] zonesNb = island.submerge3Zones();
//        this.viewIsland.submerge3ViewZones(
//                this.viewIsland.getElement(zonesNb[0]),
//                this.viewIsland.getElement(zonesNb[1]),
//                this.viewIsland.getElement(zonesNb[2]));
//    }



}



