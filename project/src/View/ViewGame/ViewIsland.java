package View.ViewGame;

import View.ViewUtil.Grid;

public class ViewIsland extends Grid {
    private int length;
    // Constructeur
    public ViewIsland(int length ) {
        super(length,length);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                this.ajouteElement( new ViewZone("",length*6,length*6));
            }
        }
    }
}