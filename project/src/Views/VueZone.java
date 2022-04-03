package Views;

import java.awt.*;

public class VueZone extends ZoneCliquable {

    public VueZone(String texte, int x, int y) {
        super(texte, x, y);
    }



    public void clicGauche() {
        setBackground(Color.WHITE);
    }

    public void clicDroit() { }

}