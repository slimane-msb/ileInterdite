package View.ViewUtil;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.*;


public class Grid extends JPanel {
    private int height;
    private int width;

    public Grid(int height, int width) {
	    setLayout(new GridLayout(height, width, 5, 5));
        //Add controls to set up horizontal and vertical gaps
        this.width=width;
        this.height=height;
    }

    public void ajouteElement (JComponent element) {
	    this.add(element);
    }

    private ViewZone2 getElement(int i){
        return this.getElement(i);
    }

   

}
