package View.ViewGame;

import java.awt.*;

public class ViewPlayer {
    private ViewZone position;
    private Color color;

    public ViewPlayer(ViewZone position, Color color) {
        this.position = position;
        this.color = color;
    }

    /**
     *
     * @return the position of the player as a viewZone, you can get then the i , j from this zoneView
     */
    public ViewZone getPosition() {
        return position;
    }

    /**
     *
     * @param position change the postion of the player to be shown in
     */
    public void setPosition(ViewZone position) {
        this.position = position;
    }

    /**
     *
     * @return the color of the player that is set on his creation by his index on the island list
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @param i the index of the player in the island player list, set the color by his index to distinguish them
     */
    public void setColor(int i) {
        switch (i){
            case 0:
                this.color = Color.RED;
                break;
            case 1:
                this.color = Color.GREEN;
                break;
            case 2:
                this.color = Color.YELLOW;
                break;
            case 3:
                this.color = Color.MAGENTA;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + i);
        }
    }
}
