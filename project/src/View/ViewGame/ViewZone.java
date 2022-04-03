package View.ViewGame;

import View.ViewUtil.Rectangle;

import java.awt.*;

public class ViewZone extends Rectangle {

    private ViewPlayer viewPlayer;
    private ViewKey viewKey;
    private ViewArteFact viewArteFact;
    private Color colorState;


    public ViewZone(String texte, int wdith, int height) {
        super(Color.black, wdith, height);
    }

    /**
     * if the zone is dry the color become black
     */
    public void toDry(){
        this.colorState=Color.BLACK;
    }

    /**
     * if the zone is flooded the color become white
     */
    public void toFlood(){
        this.colorState=Color.white;
    }

    /**
     * if the zone is subme the color become black
     */
    public void toSubmerge(){
        this.colorState=Color.blue;
    }


    public void leftClic() {}

    public void rightClic() { }

}