package View.Button;

import View.ViewUtil.Rectangle;

import java.awt.*;

public abstract class Button extends Rectangle {

    public Button(String text, int width, int height, int x, int y) {
        super(Color.WHITE,width,height);
        super.changeTexte(text);
    }

    public void leftClic() {
    }

    public void rightClic() {
    }
}
