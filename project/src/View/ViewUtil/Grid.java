package View.ViewUtil;
import View.ViewGame.ViewZone;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.*;


public class Grid extends JPanel {
    private int height;
    private int width;

    public Grid(int height, int width) {
	    setLayout(new GridLayout(height, width, 5, 5));
        this.width=width;
        this.height=height;
    }

    public void ajouteElement (JComponent element) {
	    this.add(element);
    }

   

}
