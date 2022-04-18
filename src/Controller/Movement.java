package Controller;
import Model.Utils.Direction;
import View.ViewUtil.Window;

import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Movement extends JPanel implements KeyListener {
    private Controller controller;
    private Window window;

    public Movement(Controller controller, Window window) {
        this.controller = controller;
        this.window = window;
        this.window.addKeyListener(this);
    }

    public Controller getController() {
        return controller;
    }
    public Window getWindow() { return window;}


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("UP");
            controller.move(Direction.up);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("DOWN");
            controller.move(Direction.down);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("LEFT");
            controller.move(Direction.left);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("RIGHT");
            controller.move(Direction.right);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("SPACE");
            controller.searchKey();
        }
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            System.out.println("Z");
            controller.dry(Direction.up);
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            System.out.println("X");
            controller.dry(Direction.down);
        }
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            System.out.println("Q");
            controller.dry(Direction.left);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("D");
            controller.dry(Direction.right);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("S");
            controller.dry(Direction.same);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
