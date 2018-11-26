import java.util.ArrayList;
import java.util.HashMap;

public class Table extends HashMap<Integer, Ligne> {

    public Table() {
        super();
    }

    /**
     * Ajouter une ligne dans la table (la ligne corresponsante à une valeur de S_n)
     * On sélectionne la valeurs maximale et on l'enrgistre avec la valeur de s corresponante.
     * @param S la valeur de s_n
     * @param valeurs toutes les valeurs de f(s_n, s_n)
     */
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
