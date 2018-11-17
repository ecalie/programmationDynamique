import java.util.ArrayList;
import java.util.HashMap;

public class Table extends HashMap<Integer, Ligne> {

    public Table() {
        super();
    }

    public void ajouterLigne(int S, int... valeurs) {
        Ligne l = new Ligne(valeurs);
        this.put(S, l);
    }

    public int getX(int s) {
        return this.get(s).getX();
    }

    public int getF(int s){
        return this.get(s).getF();
    }


}
