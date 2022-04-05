package Controller;

import Model.Island.Island;
import View.ViewUtil.Rectangle;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.concurrent.RecursiveAction;

public class RectangleController {
    private Island island;
    private Rectangle rectangle;

    public RectangleController(Island island, Rectangle rectangle) {
        this.island = island;
        this.rectangle = rectangle;
    }

    public Island getIsland() {
        return island;
    }

    public void setIsland(Island island) {
        this.island = island;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

//    public abstract void leftClic();
//    public abstract void rightClic();



    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}
