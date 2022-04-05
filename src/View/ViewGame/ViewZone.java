package View.ViewGame;

import Controller.Controller;
import View.ViewUtil.Rectangle;

import java.awt.*;

public class ViewZone extends Rectangle {

    private ViewPlayer viewPlayer;
    private ViewKey viewKey;
    private ViewArteFact viewArteFact;



    public ViewZone(Controller controller, int width, int height, ViewPlayer viewPlayer, ViewKey viewKey, ViewArteFact viewArteFact, Color colorState) {
        this(controller, width, height);
        this.viewPlayer = viewPlayer;
        this.viewKey = viewKey;
        this.viewArteFact = viewArteFact;
    }

    public ViewZone(Controller controller, int wdith, int height) {
        super(controller, Color.black, wdith, height);
    }

    /**
     * if the zone is dry the color become black
     */
    public void setColorDry(){
        super.setColor(Color.BLACK);
    }

    /**
     * if the zone is flooded the color become white
     */
    public void setColorFlooded(){
        super.setColor(Color.white);
    }

    /**
     * if the zone is subme the color become black
     */
    public void setColorSubmerged(){
        super.setColor(Color.blue);
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
        return super.getColor();
    }

    public void setColorState(Color colorState) {
        super.setColor( colorState);
    }

    public void leftClic() {
        super.setColor(Color.green);
    }

    public void rightClic() { }

}