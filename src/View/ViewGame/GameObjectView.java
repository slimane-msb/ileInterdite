package View.ViewGame;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObjectView {
    private double x, y;

    private double velX, velY;

    private Dimension dimension;

    private BufferedImage image;

    public GameObjectView(double x, double y, BufferedImage image){
        setLocation(x, y);
        setImage(image);

        if(image != null){
            setDimension(image.getWidth(), image.getHeight());
        }

        setVelX(0);
        setVelY(0);

    }

    public void draw(Graphics g) {
        BufferedImage style = getImage();
        if(style != null){
            g.drawImage(style, (int)x, (int)y, null);
        }

    }

    public void setLocation(double x, double y) {
        setX(x);
        setY(y);
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Dimension getDimension(){
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public void setDimension(int width, int height){ this.dimension =  new Dimension(width, height); }

    public BufferedImage getImage() {
        return image;
    }


    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }



}
