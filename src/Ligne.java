public class Ligne {

    private double f;
    private int x;

    /**
     * Recherchela valeurs maximale parmi une liste de valeurs et l'enrgistrer avec l'indice de cetet valeur.
     * On enregistre la valeur de f* et x*.
     * @param valeurs
     */
    public Ligne(double... valeurs) {
        double max = valeurs[0];
        int ind = 0;
        for (int i = 0 ; i < valeurs.length ; i++) {
            if (max < valeurs[i]) {
                max = valeurs[i];
                ind = i;
            }
        }
        this.f = max;
        this.x = ind*5;
    }

    public double getF() {
        return f;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
