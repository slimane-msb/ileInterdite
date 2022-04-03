package View.ViewUtil;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame {

    private JPanel elements;

    public Window(String nom) {
	super(nom);
	this.elements = new JPanel();
	this.add(elements);
    }

    public void ajouteElement(JComponent element) {
	elements.add(element);
    }

    public void dessineFenetre() {
	this.pack();
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
