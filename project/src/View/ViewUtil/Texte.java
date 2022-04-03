package View.ViewUtil;

import javax.swing.JLabel;

public class Texte extends JLabel {

    public Texte(String texte) {
	super(texte);
    }

    public void changeTexte(String texte) {
	this.setText(texte);
	this.repaint();
    }

}
