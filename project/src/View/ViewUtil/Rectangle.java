package View.ViewUtil;

import Controller.Controller;

import javax.naming.ldap.Control;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public abstract class Rectangle extends JPanel implements MouseListener {

    private Controller controller;
    private Texte texte;
    private Color color;
    private int width,height; // later
    private int x,y; // for postion :: later
    // private image later

    public Rectangle(Controller controller, Color color, int width, int height, int x, int y) {
        this(controller, color,width,height);
        // position rectangle in (x,y) cordiante
        // code here
    }

    public Rectangle(Controller controller,Color color, int width, int height) {
        this.controller=controller;
        setPreferredSize(new Dimension(width, height));
        addMouseListener(this);
        this.texte = new Texte("");
        this.add(this.texte);
        setBackground(color);
    }


    public Controller getController() {
        return controller;
    }

    public Color getColor() {
        return color;
    }


    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
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



