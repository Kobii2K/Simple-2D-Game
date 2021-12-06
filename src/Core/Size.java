package Core;

public class Size {
    private int largeur;
    private int longueur;

    public Size(int largeur, int longueur) {
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
}
