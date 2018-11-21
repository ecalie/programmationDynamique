public class Ligne {

    private double f;
    private int x;

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
        this.x = ind;
    }

    public double getF() {
        return f;
    }

    public int getX() {
        return x*5;
    }
}
