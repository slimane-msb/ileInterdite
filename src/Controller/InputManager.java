package Controller;

import Model.Utils.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputManager implements KeyListener, MouseListener{

    private Controller controller;

    InputManager(Controller controller) {
        this.controller = controller; }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        GameStatus status = controller.getGameStatus();
        ButtonAction currentAction = ButtonAction.NO_ACTION;

        if (keyCode == KeyEvent.VK_UP) {
            System.out.println("UP");
            currentAction = ButtonAction.UP;
        }
        else if(keyCode == KeyEvent.VK_DOWN){
            System.out.println("DOWN");
            currentAction = ButtonAction.DOWN;
        }
        else if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("RIGHT");
            currentAction = ButtonAction.RIGHT;
        }
        else if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("LEFT");
            currentAction = ButtonAction.LEFT;
        }
        else if (keyCode == KeyEvent.VK_ENTER) {
            System.out.println("ENTER");
            currentAction = ButtonAction.SELECT;
        }
        else if (keyCode == KeyEvent.VK_ESCAPE) {
            System.out.println("ESC");
            currentAction = ButtonAction.GO_TO_START_SCREEN;

        }
        else if (keyCode == KeyEvent.VK_SPACE){
            System.out.println("SPACE");
            currentAction = ButtonAction.KEY;
        }
        else if (keyCode == KeyEvent.VK_Z) {
            System.out.println("Z");
            currentAction = ButtonAction.DRY_UP;
        }
        else if (keyCode == KeyEvent.VK_X) {
            System.out.println("X");
            currentAction = ButtonAction.DRY_DOWN;
        }
        else if (keyCode == KeyEvent.VK_Q) {
            System.out.println("Q");
            currentAction = ButtonAction.DRY_LEFT;
        }
        else if (keyCode == KeyEvent.VK_D) {
            System.out.println("D");
            currentAction = ButtonAction.DRY_RIGHT;
        }
        else if (keyCode == KeyEvent.VK_S) {
            System.out.println("S");
            currentAction = ButtonAction.DRY_ON;
        }

        notifyInput(currentAction);
    }

    @Override
    public void keyReleased(KeyEvent event) { }

    private void notifyInput(ButtonAction action) {
        if(action != ButtonAction.NO_ACTION) {
            controller.receiveInput(action);
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
