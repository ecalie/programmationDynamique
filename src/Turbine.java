public class Turbine {

    private int numero;
    private int debitMax;
    private int debitMaxReel;
    private int debitReel;
    private double[][] coefficientPuissance;

    public Turbine(int numero, int debitMax, double[][] coefficientPuissance) {
        this.numero = numero;
        this.debitMax = debitMax;
        this.debitMaxReel = debitMax;
        this.debitReel = 0;
        this.coefficientPuissance = coefficientPuissance;
    }

    public double puissance(int debit) {
        double puissance=0;
        double hauteurChuteNette = Constante.elevAmont
                - (0.003261 * Constante.debitTotal + 137.4)
                - Constante.coeffPertes * debit * debit;
        for(int i = 0; i<coefficientPuissance.length; i=i+1){
            for(int j = 0;j<coefficientPuissance[i].length;j=j+1){
                puissance = puissance + coefficientPuissance[i][j] * Math.pow(hauteurChuteNette, i) * Math.pow(debit, j);
            }
        }
        return puissance;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDebitMax() {
        return debitMax;
    }

    public void setDebitMax(int debitMax) {
        this.debitMax = debitMax;
    }

    public int getDebitMaxReel() {
        return debitMaxReel;
    }

    public void setDebitMaxReel(int debitMaxReel) {
        this.debitMaxReel = debitMaxReel;
    }

    public int getDebitReel() {
        return debitReel;
    }

    public void setDebitReel(int debitReel) {
        this.debitReel = debitReel;
    }

    public double[][] getCoefficientPuissance() {
        return coefficientPuissance;
    }

    public void setCoefficientPuissance(double[][] coefficientPuissance) {
        this.coefficientPuissance = coefficientPuissance;
    }
}
