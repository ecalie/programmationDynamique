public class Turbine {

    private int numero;
    private int debitMax;
    private int debitMaxReel;
    private int debitReel;

    private int[][] coefficientPuissance;

    public Turbine(int num, int deb, int[][] coeffs) {
        this.numero = num;
        this.debitMax = deb;
        this.coefficientPuissance = coeffs;
    }

    public int puissance(int hauteurChuteNette, int debit) {
        return 0;
    }
}
