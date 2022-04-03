package View.ViewUtil;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.GridLayout;


public class Grid extends JPanel {

    public Grid(int height, int width) {
	    setLayout(new GridLayout(height, width, 5, 5));
    }

    public void ajouteElement (JComponent element) {
	this.add(element);
    }

}
