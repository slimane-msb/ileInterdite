package View.ViewGame;

import Controller.Controller;
import Model.Utils.Level;
import View.ViewUtil.Grid;

public class ViewIsland extends Grid {
    private int length;
    private  Controller controller;
    private ViewZone[][] viewZones;
    // Constructeur
    public ViewIsland(Controller controller, int length ) {
        super(length,length);
        this.viewZones = new ViewZone[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                viewZones[i][j] = new ViewZone(controller,length*6,length*6,i,j);
                //
                this.ajouteElement(viewZones[i][j] );
            }
        }
    }

    /**
     *
     * @param i index i in the grid
     * @param j index j in the grid
     * @return the view zone [i][j]
     */
    public ViewZone getViewZones(int i, int j) {
        return viewZones[i][j];
    }



    /**
     * set color of given zone to blue
     * @param viewZone a view of zone
     */
    public void sebmergeViewZone( ViewZone viewZone){
        viewZone.setColorSubmerged();
    }

    /**
     * set color of given 3 zones to blue
     * @param viewZone a view of zone 1
     * @param viewZone2 a view of zone 2
     * @param viewZone3 a view of zone 3
     */
    public void submerge3ViewZones(ViewZone viewZone,ViewZone viewZone2,ViewZone viewZone3){
        sebmergeViewZone(viewZone);
        sebmergeViewZone(viewZone2);
        sebmergeViewZone(viewZone3);
    }

    //

}