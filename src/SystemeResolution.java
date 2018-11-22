public class SystemeResolution {

    private Table table1;
    private Table table2;
    private Table table3;
    private Table table4;
    private Table table5;

    public void resoudre(Turbine turbine1, Turbine turbine2, Turbine turbine3, Turbine turbine4, Turbine turbine5 ) {
        // Initialisation des turbines
        turbine1.setDebitReel(0);
        turbine2.setDebitReel(0);
        turbine3.setDebitReel(0);
        turbine4.setDebitReel(0);
        turbine5.setDebitReel(0);

        // backward pass
        //      - n = 5
        table5 = this.creerTable5(turbine5);

        //      - n = 4 .. 2
        table4 = this.creerTable4_2(turbine4);
        table3 = this.creerTable4_2(turbine3);
        table2 = this.creerTable4_2(turbine2);

        //      - n = 1
        table1 =  this.creerTable1(turbine1);

        // Forward pass
        int Q1 = table1.getX(Constante.debitTotal);
        int S1 = Constante.debitTotal - Q1;

        int Q2 = table2.getX(S1);
        int S2 = S1 - Q2;

        int Q3 = table3.getX(S2);
        int S3 = S2 - Q3;

        int Q4 = table4.getX(S3);
        int S4 = S3 - Q4;

        int Q5 = table5.getX(S4);
        //int S5 = S4 - Q5;


        turbine1.setDebitReel(Q1);
        turbine2.setDebitReel(Q2);
        turbine3.setDebitReel(Q3);
        turbine4.setDebitReel(Q4);
        turbine5.setDebitReel(Q5);
    }

    public Table creerTable5(Turbine tur) {
        Table table5 = new Table();
        for (int s = 0 ; s <= Constante.debitTotal ; s += 5) {
            double f;
            if (s > tur.getDebitMaxReel())
                f = 0;
            else
                f = tur.puissance(s);
            table5.ajouterLigne5(s, (s>tur.getDebitMaxReel()?tur.getDebitMaxReel()/5:s/5), f);
        }
        return table5;
    }

    public Table creerTable4_2(Turbine tur) {
        Table table = new Table();
        for (int s = 0 ; s <= Constante.debitTotal ; s += 5) {
            double[] fs = new double[tur.getDebitMaxReel() / 5 + 1];
            for (int x = 0 ; x <= tur.getDebitMaxReel();  x += 5) {
                if (x > s || x > tur.getDebitMaxReel())
                    fs[x/5] = 0;
                else
                    fs[x/5] = f(s, x, tur);
            }
            table.ajouterLigne(s, fs);
        }
        return table;
    }

    public Table creerTable1(Turbine tur) {
        Table table = new Table();
        double[] fs = new double[(int) (tur.getDebitMaxReel() / 5 + 1)];
        for (int x = 0 ; x <= tur.getDebitMaxReel() ;  x += 5) {
            if (x > tur.getDebitMaxReel())
                fs[x/5] = 0;
            else
                fs[x/5] = f(Constante.debitTotal, x, tur);
        }
        table.ajouterLigne(Constante.debitTotal, fs);
        return table;
    }

    public double f(int debitRestant, int debit, Turbine turb) {
        if (debit > debitRestant)
            return 0;
        switch (turb.getNumero()) {
            case 1:
                return turb.puissance(debit) + table2.get(debitRestant - debit).getF();
            case 2:
                return turb.puissance(debit) + table3.get(debitRestant - debit).getF();
            case 3:
                return turb.puissance(debit) + table4.get(debitRestant - debit).getF();
            case 4:
                return turb.puissance(debit) + table5.get(debitRestant - debit).getF();
        }
       return 0;
    }
}
