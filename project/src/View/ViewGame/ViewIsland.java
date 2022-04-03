package View.ViewGame;

import View.ViewUtil.Grid;

public class ViewIsland extends Grid {
    private int length;
    // Constructeur
    public ViewIsland(int length ) {
        super(length,length);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                this.ajouteElement( new ViewZone(length*6,length*6));
            }
        }
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

}