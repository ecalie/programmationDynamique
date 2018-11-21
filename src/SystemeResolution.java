public class SystemeResolution {

    private Table table1;
    private Table table2;
    private Table table3;
    private Table table4;
    private Table table5;

    public void resoudre(Turbine turbine1, Turbine turbine2, Turbine turbine3, Turbine turbine4, Turbine turbine5 ) {
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
        double Q1 = table1.getX(Constante.debitTotal);
        double S1 = Constante.debitTotal - Q1;

        double Q2 = table2.getX(S1);
        double S2 = S1 - Q2;

        double Q3 = table3.getX(S2);
        double S3 = S2 - Q3;

        double Q4 = table4.getX(S3);
        double S4 = S3 - Q4;

        double Q5 = table5.getX(S4);
        double S5 = S4 - Q5;

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
            for (int x = 0 ; x <= tur.getDebitMaxReel();  x += 5) {
                if (x > s)
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
            fs[x/5] = f(Constante.debitTotal, x, tur);
        }
        table.ajouterLigne(Constante.debitTotal, fs);
        return table;
    }

    public double f(double debitRestant, double debit, Turbine turb) {
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
