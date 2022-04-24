package View.ViewGame;

import Controller.Controller;
import View.ViewUtil.ImageLoader;

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
            this.viewPlayers.add(new ViewPlayer(controller.getIsland().getPlayer(i-1).getPosition().getX()*controller.getIMAGELENGTH(),controller.getIsland().getPlayer(i-1).getPosition().getY()*controller.getIMAGELENGTH(), loader.loadImage("/player/"+i+".png") ));
        ;
        // loading the 4 artefact
        int k =0;

        this.air = new ViewArteFact(controller.getIsland().getAir().getPostion().getX()*controller.getIMAGELENGTH(),controller.getIsland().getAir().getPostion().getY()*controller.getIMAGELENGTH(),loader.loadImage("/artefact/air.png"));
        this.land = new ViewArteFact(controller.getIsland().getLand().getPostion().getX()*controller.getIMAGELENGTH(),controller.getIsland().getLand().getPostion().getY()*controller.getIMAGELENGTH(),loader.loadImage("/artefact/land.png"));
        this.water = new ViewArteFact(controller.getIsland().getWater().getPostion().getX()*controller.getIMAGELENGTH(),controller.getIsland().getWater().getPostion().getY()*controller.getIMAGELENGTH(),loader.loadImage("/artefact/water.png"));
        this.fire = new ViewArteFact(controller.getIsland().getFire().getPostion().getX()*controller.getIMAGELENGTH(),controller.getIsland().getFire().getPostion().getY()*controller.getIMAGELENGTH(),loader.loadImage("/artefact/fire.png"));


        this.viewZones = new ViewZone[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                //load images
                // load first image as helicop
                int imgIndex = (j*length+i)%9;
                boolean heliport = i==controller.getIsland().getHelicop().getX() && j==controller.getIsland().getHelicop().getY();
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