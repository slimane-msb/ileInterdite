package View.ViewGame;

import Controller.Controller;
import View.ViewUtil.ImageLoader;

import javax.swing.*;
import javax.swing.text.PlainView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ViewIsland {
    private int length;
    private  Controller controller;
    private ViewZone[][] viewZones;
    private ArrayList<ViewPlayer> viewPlayers;
    private ViewArteFact land;
    private ViewArteFact water;
    private ViewArteFact air;
    private ViewArteFact fire;


    public ViewIsland(Controller controller, int length ) {
        ImageLoader loader = controller.getImageLoader();
        this.viewPlayers = new ArrayList<ViewPlayer>();
        // loading the 4 players
        for (int i=1;i<5;i++)
            this.viewPlayers.add(new ViewPlayer(0,0, loader.loadImage("/player/"+i+".png") ));// x y will be set in heliport
        // loading the 4 artefact
        int k =0;
        this.land = new ViewArteFact(0,(k++)*controller.getIMAGELENGTH(),loader.loadImage("/artefact/land.png"));
        this.water = new ViewArteFact(0,(k++)*controller.getIMAGELENGTH(),loader.loadImage("/artefact/water.png"));
        this.fire = new ViewArteFact(0,(k++)*controller.getIMAGELENGTH(),loader.loadImage("/artefact/fire.png"));
        this.air = new ViewArteFact(0,(k++)*controller.getIMAGELENGTH(),loader.loadImage("/artefact/air.png"));

        this.viewZones = new ViewZone[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                //load images
                // load first image as helicop
                int imgIndex = (j*length+i)%14;
                boolean heliport = i==0 && j==0;
                BufferedImage dryImage;
                BufferedImage floodedImage;
                if(heliport) {
                    dryImage = loader.loadImage("/zones/h.png");
                    floodedImage = loader.loadImage("/zones/hf.png");
                }else {
                    dryImage = loader.loadImage("/zones/" + imgIndex + ".png");
                    floodedImage = loader.loadImage("/zones/" + imgIndex + "f.png");
                }
                viewZones[i][j] = new ViewZone(i*controller.getIMAGELENGTH(), j* controller.getIMAGELENGTH(), dryImage, floodedImage);
            }
        }
        for (int i=0;i<4;i++) {
            this.viewZones[0][i].addViewPlayer(this.viewPlayers.get(i));
        }

        // later it's gonna be done in ctroller // once it's picked remove it from zone, set zone attribute not artefect itself, it gonna printed on list
        this.viewZones[1][2].setViewArtefact(this.land);
        this.viewZones[3][1].setViewArtefact(this.water);
        this.viewZones[2][1].setViewArtefact(this.fire);
        this.viewZones[0][3].setViewArtefact(this.air);


        // testing: adding some keys to player
        


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



    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public ViewZone[][] getViewZones() {
        return viewZones;
    }

    public void setViewZones(ViewZone[][] viewZones) {
        this.viewZones = viewZones;
    }

    public ArrayList<ViewPlayer> getViewPlayers() {
        return viewPlayers;
    }

    public void setViewPlayers(ArrayList<ViewPlayer> viewPlayers) {
        this.viewPlayers = viewPlayers;
    }

    public ViewArteFact getLand() {
        return land;
    }

    public void setLand(ViewArteFact land) {
        this.land = land;
    }

    public ViewArteFact getWater() {
        return water;
    }

    public void setWater(ViewArteFact water) {
        this.water = water;
    }

    public ViewArteFact getAir() {
        return air;
    }

    public void setAir(ViewArteFact air) {
        this.air = air;
    }

    public ViewArteFact getFire() {
        return fire;
    }

    public void setFire(ViewArteFact fire) {
        this.fire = fire;
    }
}