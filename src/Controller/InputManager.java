package Controller;

import Model.Utils.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputManager implements KeyListener, MouseListener {
    private GameEngine engine;

    InputManager(GameEngine engine) {
        this.engine = engine; }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        GameStatus status = engine.getGameStatus();

        if (keyCode == KeyEvent.VK_UP) {
            System.out.println("UP");
            if(status == GameStatus.START_SCREEN) {
                System.out.println(" sur ecran accueil"); //TODO
                engine.selectLevel(true);
            }
            else
                engine.move(Direction.up);
        }
        else if(keyCode == KeyEvent.VK_DOWN){
            System.out.println("DOWN");
            if(status == GameStatus.START_SCREEN) {
                System.out.println(" sur ecran accueil"); //TODO
                engine.selectLevel(false);
            }
            else
                engine.move(Direction.down);
        }
        else if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("LEFT");
            engine.move(Direction.left);
        }
        else if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("RIGHT");
            engine.move(Direction.right);
        }
        else if (keyCode == KeyEvent.VK_ENTER) {
            System.out.println("ENTER");
            if(status == GameStatus.START_SCREEN) {
                System.out.println(" sur ecran accueil"); //TODO
                engine.startGame();
            }
            else
                engine.takeArtefact();
        }
        else if (keyCode == KeyEvent.VK_SPACE) {
            System.out.println("SPACE");
            engine.searchKey();
        }

        else if (keyCode == KeyEvent.VK_Z) {
            System.out.println("Z");
            engine.dry(Direction.up);
        }
        else if (keyCode == KeyEvent.VK_X) {
            System.out.println("X");
            engine.dry(Direction.down);
        }
        else if (keyCode == KeyEvent.VK_Q) {
            System.out.println("Q");
            engine.dry(Direction.left);
        }
        else if (keyCode == KeyEvent.VK_D) {
            System.out.println("D");
            engine.dry(Direction.right);
        }
        else if (keyCode == KeyEvent.VK_S) {
            System.out.println("S");
            engine.dry(Direction.same);
        }


    }


    @Override
    public void mousePressed(MouseEvent e) {
        //TODO voir pour nextround si on le gère ici ou dans la view (à la création du bouton)
    }

    @Override
    public void keyReleased(KeyEvent event) {}

    @Override
    public void keyTyped(KeyEvent arg0) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
