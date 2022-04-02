package game.Ile;

public class Zone {
    // Attributs
    private boolean occupee;
    private Ile ile;

    // Constructeur
    public Zone(Plateau p) {
        // Initialisation d'une case cliquable, de dimensions 40*40 pixels.
        super(40, 40);
        // Initialisation des attributs
        this.occupee = false;
        this.ile = p;
    }

    // Pour permettre à un objet [Plateau] de consulter l'état d'une case.
    public boolean estOccupee() {return this.occupee;}

    // Méthodes pour occuper ou libérer une case.
    public void occupe() { this.occupee = true; }
    public void libere() { this.occupee = false; }


}
