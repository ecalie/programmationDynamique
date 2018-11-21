import java.util.ArrayList;
import java.util.HashMap;

public class Table extends HashMap<Double, Ligne> {

    public Table() {
        super();
    }

    public void ajouterLigne(double S, double... valeurs) {
        Ligne l = new Ligne(valeurs);
        this.put(S, l);
    }

    public double getX(double s) {
        return this.get(s).getX();
    }

    public double getF(double s){
        return this.get(s).getF();
    }


}
