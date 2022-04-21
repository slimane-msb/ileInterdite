package Controller;

import Model.Island.Island;
import Model.Utils.Direction;
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
    private Movement action;
    private ToDry toDry;
    //manage rounds
    private int playerIndex = 0;
    private int nbAction = 3;
    private int currRound = 0;

    public Controller(Island island) {
        this.length = island.getLength();
        this.window = new Window(island.getLength() + "ile interdite");
        this.island = island;
        this.searchKey = new SearchKey(this);
        this.toDry = new ToDry(this);
        this.endRound = new EndRound(this);
        this.viewIsland = new ViewIsland(this, island.getLength());
        this.window.ajouteElement(viewIsland);
        this.window.ajouteElement(endRound);
        this.window.dessineFenetre();
        this.action = new Movement(this, this.window);
    }

    private String gameStateString() {
        return "player: " + playerIndex + " Nb actions left: " + (3 - nbAction);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public Island getIsland() {
        return island;
    }

    public void setIsland(Island island) {
        this.island = island;
    }

    public ViewIsland getViewIsland() {
        return viewIsland;
    }

    public void setViewIsland(ViewIsland viewIsland) {
        this.viewIsland = viewIsland;
    }

    public SearchKey getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(SearchKey searchKey) {
        this.searchKey = searchKey;
    }

    public EndRound getEndRound() {
        return endRound;
    }

    public void setEndRound(EndRound endRound) {
        this.endRound = endRound;
    }

    public ToDry getToDry() {
        return toDry;
    }

    public void setToDry(ToDry toDry) {
        this.toDry = toDry;
    }

    public Movement getAction() { return action;}

    public void setAction(Movement action) {this.action = action; }

    /**
     * get the number of the zone we need to submerge, and then call the methode submergeView to color ble
     */
    public void endRound() {
        int[][] zonesNb = island.submerge3NotSubmergedZones();
        this.viewIsland.submerge3ViewZones(
                this.viewIsland.getViewZones(zonesNb[0][0], zonesNb[0][1]),
                this.viewIsland.getViewZones(zonesNb[1][0], zonesNb[1][1]),
                this.viewIsland.getViewZones(zonesNb[2][0], zonesNb[2][1]));
    }

    public void actionMade() {
        if (currRound == 2) {
            playerIndex = (playerIndex + 1) % 4;
            this.endRound();
        }
        currRound = (currRound + 1) % 3;

    }

    public void move(Direction dir){ //en fonction de la position de player
        //TODO emilie
    }

    public void dry(Direction dir){
        //TODO emilie
    }

    public void searchKey(){
        //TODO emilie
    }
}




