package Views;

import java.awt.*;

public class ViewZone extends ViewCommand {

    public ViewZone(String texte, int x, int y) {
        super(texte, x, y);
    }
    public void clicGauche() {
        setBackground(Color.WHITE);
    }

    public void clicDroit() { }

}