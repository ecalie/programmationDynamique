public class Main {


    public static void main(String[] args) {
        // créer les turbines
        //      - turbine 1
        double[][] coeffTurbine1 = {{0.01795,-0.1966,0.002889,-1.194*Math.pow(10,-5)},
                                    {-0.0004493,0.008152,7.483*Math.pow(10,-6)}};
        Turbine turbine1 = new Turbine(1, 160,coeffTurbine1);

        //      - turbine 2
        double[][] coeffTurbine2 = {{0.3245,-0.237,0.003811,-0.00001667},{-0.009282,0.006285,0.00002281}};
        Turbine turbine2 = new Turbine(2, 160,coeffTurbine2);

        //      - turbine 3
        double[][] coeffTurbine3 = {{0.001055,-0.216,0.003543,-0.00001572},{-0.00004689,0.006365,0.0000221}};
        Turbine turbine3 = new Turbine(3, 160, coeffTurbine3);

        //      - turbine 4
        double[][] coeffTurbine4 = {{0.03327,-0.1916,0.003544,-0.00001693},{-0.001008,0.004989,0.00003474}};
        Turbine turbine4 = new Turbine(4, 160, coeffTurbine4);

        //      - turbine 5
        double[][] coeffTurbine5 = {{-0.004301,-0.08809,0.00288,-0.00003086,0.00000008458},{0.0001528,0.00009614,0.0001387,-0.0000004462}};
        Turbine turbine5 = new Turbine(5, 160, coeffTurbine5);

        // initialiser les constantes (entrée)
        Constante.debitTotal = 580;
        Constante.elevAmont = 172.110;


        new SystemeResolution().resoudre(turbine1, turbine2, turbine3, turbine4, turbine5);
    }
}
