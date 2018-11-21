public class Turbine {

    private int numero;
    private double debitMax;
    private double debitMaxReel;
    private double debitReel;
    private double[][] coefficientPuissance;

    public Turbine(int numero, int debitMax, double[][] coefficientPuissance) {
        this.numero = numero;
        this.debitMax = debitMax;
        this.debitMaxReel = debitMax;
        this.debitReel = 0;
        this.coefficientPuissance = coefficientPuissance;
    }

    public double puissance(double debit) {
        double puissance=0;
        double hauteurChuteNette = Constante.elevAmont
                - (0.003261 * Constante.debitTotal + 137.4)
                - Constante.coeffPertes * debit * debit;
        for(int i = 0; i<coefficientPuissance.length; i=i+1){
            for(int j = 0;j<coefficientPuissance[i].length;j=j+1){
                System.out.println("h^" + i + "  q^" + j);
                System.out.println(coefficientPuissance[i][j]);
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

    public double getDebitMax() {
        return debitMax;
    }

    public void setDebitMax(double debitMax) {
        this.debitMax = debitMax;
    }

    public double getDebitMaxReel() {
        return debitMaxReel;
    }

    public void setDebitMaxReel(double debitMaxReel) {
        this.debitMaxReel = debitMaxReel;
    }

    public double getDebitReel() {
        return debitReel;
    }

    public void setDebitReel(double debitReel) {
        this.debitReel = debitReel;
    }

    public double[][] getCoefficientPuissance() {
        return coefficientPuissance;
    }

    public void setCoefficientPuissance(double[][] coefficientPuissance) {
        this.coefficientPuissance = coefficientPuissance;
    }
}
