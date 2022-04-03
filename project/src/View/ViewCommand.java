package View;
import View.Texte;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public abstract class ViewCommand extends JPanel implements MouseListener {

    private Texte texte;
    private Color color;

    public ViewCommand(String texte, int x, int y) {
	this(x, y);
	this.texte = new Texte(texte);
	this.add(this.texte);
    }

    public ViewCommand(int x, int y) {
	setPreferredSize(new Dimension(x, y));
	addMouseListener(this);
	setBackground(Color.WHITE);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void changeTexte(String texte) {
    	this.texte.changeTexte(texte);
    }

    public abstract void leftClic();
    public abstract void rightClic();

    public void mouseClicked(MouseEvent e) {
	if (SwingUtilities.isRightMouseButton(e)) {
	    this.rightClic();
	} else {
	    this.leftClic();
	}
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}




}

/*

  purpose of the button

*/

