public class SystemeResolution {

    public void resoudre() {
        // création des turbines
        // TODO : ajouter les coefficients pour le calcul de la puissance
        Turbine turbine1 = new Turbine(1, 0, null);
        Turbine turbine2 = new Turbine(2, 0, null);
        Turbine turbine3 = new Turbine(3, 0, null);
        Turbine turbine4 = new Turbine(4, 0, null);
        Turbine turbine5 = new Turbine(5, 0, null);

        // calcul de la hauteur de chutte nette
        // h = elevAmon - elevAval - pertes
        int h = (int) (Constante.elevAmont
                - 0.003261 * Constante.debitTotal + 137.4
                - Constante.coeffPertes * Constante.debitTotal * Constante.debitTotal);

        // backward pass
        //      - n = 5
        Table table5 = this.creerTable5(turbine5, h);

        //      - n = 4 .. 2
        Table table4 = this.creerTable4_2(turbine4, h);
        Table table3 = this.creerTable4_2(turbine3, h);
        Table table2 = this.creerTable4_2(turbine2, h);

        //      - n = 1
        Table table1 =  this.creerTable1(turbine1, h);

        // Forward pass
        int Q1 = table1.getX(Constante.debitTotal);
        int S1 = table1.getF(Constante.debitTotal);

        int Q2 = table2.getX(S1 - Q1);
        int S2 = table2.getF(S1 - Q1);

        int Q3 = table2.getX(S2 - Q2);
        int S3 = table2.getF(S2 - Q2);

        int Q4 = table2.getX(S3 - Q3);
        int S4 = table2.getF(S3 - Q3);

        int Q5 = table2.getX(S4 - Q4);
        int S5 = table2.getF(S4 - Q4);

        System.out.println("debit turbine 1 : " + Q1);
        System.out.println("debit turbine 2 : " + Q2);
        System.out.println("debit turbine 3 : " + Q3);
        System.out.println("debit turbine 4 : " + Q4);
        System.out.println("debit turbine 5 : " + Q5);
    }

    public Table creerTable5(Turbine tur, int hauteur) {
        Table table5 = new Table();
        for (int s = 0 ; s <= Constante.debitTotal ; s += 5) {
            int f = tur.puissance(hauteur, s);
            table5.ajouterLigne(s, f);
        }
        return table5;
    }

    public Table creerTable4_2(Turbine tur, int hauteur) {
        Table table = new Table();
        for (int s = 0 ; s <= Constante.debitTotal ; s += 5) {
            int[] fs = new int[tur.getDebitMaxReel() / 5 + 1];
            for (int x = 0 ; x < tur.getDebitMaxReel() ;  x += 5) {
                fs[x/5] = tur.puissance(hauteur, s);
            }
            table.ajouterLigne(s, fs);
        }
        return table;
    }

    public Table creerTable1(Turbine tur, int hauteur) {
        Table table = new Table();
        int[] fs = new int[tur.getDebitMaxReel() / 5 + 1];
        for (int x = 0 ; x < tur.getDebitMaxReel() ;  x += 5) {
            fs[x/5] = tur.puissance(hauteur, Constante.debitTotal);
        }
        table.ajouterLigne(Constante.debitTotal, fs);
        return table;
    }
}
