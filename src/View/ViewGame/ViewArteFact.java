package View.ViewGame;

import java.awt.image.BufferedImage;

public class ViewArteFact extends  GameObjectView{

    private ViewZone position;

    public ViewArteFact(double x, double y, BufferedImage image) {
        super(x, y, image);
    }

    public ViewArteFact(double x, double y, BufferedImage image, ViewZone position) {
        super(x, y, image);
        this.position = position;
    }

    public ViewArteFact(ViewArteFact arteFact) {
        this(arteFact.getX(),arteFact.getY(), arteFact.getImage());
    }
}
