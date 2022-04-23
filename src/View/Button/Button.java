package View.Button;

import Controller.Controller;

import java.awt.*;

public abstract class Button extends Rectangle {

    public Button(Controller controller, String text, int width, int height, int x, int y) {
        super(controller, Color.WHITE,width,height);
        super.changeTexte(text);
    }

    public void leftClic() {
    }
    // a changer
    public void rightClic() {
    }

}
