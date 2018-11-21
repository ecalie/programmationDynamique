import java.util.ArrayList;
import java.util.HashMap;

public class Table extends HashMap<Integer, Ligne> {

    public Table() {
        super();
    }

    public void ajouterLigne(int S, double... valeurs) {
        Ligne l = new Ligne(valeurs);
        this.put(S, l);
    }

    // cas particuler pour la table 5
    public void ajouterLigne5(int S, int x, double... valeurs) {
        Ligne l = new Ligne(valeurs);
        l.setX(x);
        this.put(S, l);
    }

    public int getX(int s) {
        return this.get(s).getX();
    }

    public double getF(double s){
        return this.get(s).getF();
    }


}
