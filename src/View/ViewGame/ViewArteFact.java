package View.ViewGame;

import java.awt.image.BufferedImage;

public class ViewArteFact extends  GameObjectView{

    public ViewArteFact(double x, double y, BufferedImage image) {
        super(x, y, image);
    }

    public ViewArteFact(ViewArteFact arteFact) {
        this(arteFact.getX(),arteFact.getY(), arteFact.getImage());
    }
}
