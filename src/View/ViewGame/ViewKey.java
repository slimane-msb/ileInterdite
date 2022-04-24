package View.ViewGame;

import javax.swing.text.View;
import java.awt.image.BufferedImage;

public class ViewKey extends ViewArteFact{
    private ViewZone position;

    public ViewKey(double x, double y, BufferedImage image) {
        super(x, y, image);
    }

    public ViewKey(double x, double y, BufferedImage image, ViewZone position) {
        super(x, y, image);
        this.position = position;
    }
}
