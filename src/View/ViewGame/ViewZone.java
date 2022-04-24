package View.ViewGame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ViewZone extends GameObjectView {
    private ViewArteFact viewArteFact;
    private BufferedImage floodedImage;
    private BufferedImage dryImage;

    public ViewZone(double x, double y, BufferedImage dryImage, BufferedImage floodedImage) {
        super(x, y, dryImage);
        this.floodedImage = floodedImage;
        this.dryImage = dryImage;

    }

    public void floodZone(){
        super.setImage(this.floodedImage);
    }

    /**
     *
     * @param x location x
     * @param y location y
     * @param floodedImage  the equivalent image with blue opacity on it
     * @param dryImage      the original image
     * @param viewArteFact : view obljct with  x,y same as for viewZone
     */
    public ViewZone(double x, double y, BufferedImage dryImage, BufferedImage floodedImage, ViewArteFact viewArteFact) {
        this(x,y,dryImage,floodedImage);
        this.viewArteFact = viewArteFact;

    }

    /**
     * spec: here is the only moment where artefact and players are beeing drawn within the zone in the same x,y as the zone
     * @param g graphics
     */
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (this.viewArteFact!=null) this.viewArteFact.draw(g);
    }



    /**
     * if the zone is dry the image will be back to original version
     */
    public void setDru(){
        super.setImage(this.dryImage);
    }

    /**
     * if the zone is flooded the image become same with blue color on it
     */
    public void setFlooded(){
        super.setImage(this.floodedImage);
    }

    /**
     * if the zone is submerged the image will desapear
     */
    public void setSubmerged(){
        super.setImage(null);
    }


    public void setViewArtefact(ViewArteFact arteFact) {
        this.viewArteFact= new ViewArteFact(arteFact);
        arteFact.setX(this.getX());
        arteFact.setY(this.getY());
    }
}
