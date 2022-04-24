package View.ViewGame;

import Model.Player.Artefact;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ViewPlayer  extends  GameObjectView{
    private ViewZone position;
    // list of artefact and list of keyu
    public ViewPlayer(double x, double y, BufferedImage image) {
        super(x, y, image);
    }

    public ViewPlayer(double x, double y, BufferedImage image, ViewZone position) {
        super(x, y, image);
        this.position = position;
    }

    public ViewPlayer(ViewPlayer pp1) {
        this(pp1.getX(), pp1.getY(), pp1.getImage());
    }
}
