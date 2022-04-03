package Views;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;


/**
 * Classe des fenetres graphiques.
 */
public class Window extends JFrame {

    /**
     * Ensemble des elements contenus dans la fenetre graphique.
     */
    private JPanel elements;
    
    /**
     * Creation d'une fenetre graphique.
     *
     * Attention, ce constructeur ne fait que definir l'objet. Pour le faire
     * afficher il faut ensuite utiliser la methode {@code dessineFenetre()}.
     *
     * @param nom Nom de la fenetre.
     */
    public Window(String nom) {
	super(nom);
	this.elements = new JPanel();
	this.add(elements);
    }

    /**
     * Ajout d'un element graphique dans la fenetre.
     *
     * @param element Element a ajouter.
     */
    public void ajouteElement(JComponent element) {
	elements.add(element);
    }
    
    /**
     * Afficher la fenetre.
     */
    public void dessineFenetre() {
	this.pack();
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
