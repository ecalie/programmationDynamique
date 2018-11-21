public class SystemeResolution {

    public void resoudre(Turbine turbine1, Turbine turbine2, Turbine turbine3, Turbine turbine4, Turbine turbine5 ) {
        // backward pass
        //      - n = 5
        Table table5 = this.creerTable5(turbine5);

        //      - n = 4 .. 2
        Table table4 = this.creerTable4_2(turbine4);
        Table table3 = this.creerTable4_2(turbine3);
        Table table2 = this.creerTable4_2(turbine2);

        //      - n = 1
        Table table1 =  this.creerTable1(turbine1);

        // Forward pass
        double Q1 = table1.getX(Constante.debitTotal);
        double S1 = table1.getF(Constante.debitTotal);

        double Q2 = table2.getX(S1 - Q1);
        double S2 = table2.getF(S1 - Q1);

        double Q3 = table3.getX(S2 - Q2);
        double S3 = table3.getF(S2 - Q2);

        double Q4 = table4.getX(S3 - Q3);
        double S4 = table4.getF(S3 - Q3);

        double Q5 = table5.getX(S4 - Q4);
        double S5 = table5.getF(S4 - Q4);

        System.out.println("debit turbine 1 : " + Q1);
        System.out.println("debit turbine 2 : " + Q2);
        System.out.println("debit turbine 3 : " + Q3);
        System.out.println("debit turbine 4 : " + Q4);
        System.out.println("debit turbine 5 : " + Q5);
    }

    public Table creerTable5(Turbine tur) {
        Table table5 = new Table();
        for (int s = 0 ; s <= Constante.debitTotal ; s += 5) {
            double f = tur.puissance(s);
            table5.ajouterLigne(s, f);
        }
        return table5;
    }

    public Table creerTable4_2(Turbine tur) {
        Table table = new Table();
        for (int s = 0 ; s <= Constante.debitTotal ; s += 5) {
            double[] fs = new double[(int) (tur.getDebitMaxReel() / 5 + 1)];
            for (int x = 0 ; x < tur.getDebitMaxReel() ;  x += 5) {
                fs[x/5] = tur.puissance(s);
            }
            table.ajouterLigne(s, fs);
        }
        return table;
    }

    public Table creerTable1(Turbine tur) {
        Table table = new Table();
        double[] fs = new double[(int) (tur.getDebitMaxReel() / 5 + 1)];
        for (int x = 0 ; x < tur.getDebitMaxReel() ;  x += 5) {
            fs[x/5] = tur.puissance(Constante.debitTotal);
        }
        table.ajouterLigne(Constante.debitTotal, fs);
        return table;
    }
}
