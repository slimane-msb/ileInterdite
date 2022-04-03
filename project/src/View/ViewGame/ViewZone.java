package View.ViewGame;

import View.ViewUtil.Rectangle;

import java.awt.*;

public class ViewZone extends Rectangle {

    private ViewPlayer viewPlayer;
    private ViewKey viewKey;
    private ViewArteFact viewArteFact;
    private Color colorState;



    public ViewZone(int width, int height, ViewPlayer viewPlayer, ViewKey viewKey, ViewArteFact viewArteFact, Color colorState) {
        this(width, height);
        this.viewPlayer = viewPlayer;
        this.viewKey = viewKey;
        this.viewArteFact = viewArteFact;
        this.colorState = colorState;
    }

    public ViewZone(int wdith, int height) {
        super(Color.black, wdith, height);
    }

    /**
     * if the zone is dry the color become black
     */
    public void setColorDry(){
        this.colorState=Color.BLACK;
    }

    /**
     * if the zone is flooded the color become white
     */
    public void setColorFlooded(){
        this.colorState=Color.white;
    }

    /**
     * if the zone is subme the color become black
     */
    public void setColorSubmerged(){
        this.colorState=Color.blue;
    }

    public ViewPlayer getViewPlayer() {
        return viewPlayer;
    }

    public void setViewPlayer(ViewPlayer viewPlayer) {
        this.viewPlayer = viewPlayer;
        // graphics code
    }

    public ViewKey getViewKey() {
        return viewKey;
    }

    public void setViewKey(ViewKey viewKey) {
        this.viewKey = viewKey;
        // graphics code
    }

    public ViewArteFact getViewArteFact() {
        return viewArteFact;
    }

    public void setViewArteFact(ViewArteFact viewArteFact) {
        this.viewArteFact = viewArteFact;
        // graphics code
    }

    public Color getColorState() {
        return colorState;
    }

    public void setColorState(Color colorState) {
        this.colorState = colorState;
    }

    public void leftClic() {}

    public void rightClic() { }

}