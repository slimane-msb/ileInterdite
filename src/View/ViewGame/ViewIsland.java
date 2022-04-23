package View.ViewGame;

import Controller.Controller;
import View.ViewUtil.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ViewIsland {
    private int length;
    private  Controller controller;
    private ViewZone[][] viewZones;


    public ViewIsland(Controller controller, int length ) {
        this.viewZones = new ViewZone[length][length];
        ImageLoader loader = controller.getImageLoader();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                //load images
                BufferedImage dryImage = loader.loadImage("/sprite.png");
                BufferedImage floodedImage = loader.loadImage("/sprite.png");
                viewZones[i][j] = new ViewZone(i, j, dryImage, floodedImage);
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
        //viewZone.setColorSubmerged();
    }

    /**
     * set color of given 3 zones to blue
     * @param viewZone a view of zone 1
     * @param viewZone2 a view of zone 2
     * @param viewZone23 a view of zone 3
     */
    public void submerge3ViewZones(ViewZone viewZone, ViewZone viewZone2, ViewZone viewZone23){
        sebmergeViewZone(viewZone);
        sebmergeViewZone(viewZone2);
        sebmergeViewZone(viewZone23);
    }

    public void drawIsland(Graphics2D g2) {
    }

    //

}