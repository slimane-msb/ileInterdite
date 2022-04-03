package View;

import View.Command.ViewCommand;

import java.awt.*;

public class ViewZone extends ViewCommand {

    public ViewZone(String texte, int x, int y) {
        super(texte, x, y);
    }
    public void leftClic() {
        setBackground(Color.WHITE);
    }

    public void rightClic() { }

}