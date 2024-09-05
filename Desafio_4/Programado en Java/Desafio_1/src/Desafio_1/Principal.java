package Desafio_1;

public class Principal {

    public static void main(String[] args) {
        // Definir el punto base
        double x0 = 1;

        // Definir el valor a predecir
        double x = 3;

        // Calcular el valor real de la función
        double valor_real = f(x);

        // Calcular los términos de la serie de Taylor hasta tercer orden
        double t0 = f(x0);
        double t1 = fPrim(x0) * (x - x0);
        double t2 = fSeg(x0) / 2 * Math.pow(x - x0, 2);
        double t3 = fTer(x0) / 6 * Math.pow(x - x0, 3);

        // Calcular la aproximación de la función usando la serie de Taylor
        double aproximacion = t0 + t1 + t2 + t3;

        // Calcular el error relativo porcentual
        double error_relativo_porcentual = Math.abs((valor_real - aproximacion) / valor_real) * 100;

        // Imprimir los resultados
        System.out.println("Valor real de la función: " + valor_real);
        System.out.println("Aproximación de la función: " + aproximacion);
        System.out.println("Error relativo porcentual: " + error_relativo_porcentual + "%");
    }

    // Definir la función
    public static double f(double x) {
        return 25 * Math.pow(x, 3) - 6 * Math.pow(x, 2) + 7 * x - 88;
    }

    // Definir las derivadas de la función
    public static double fPrim(double x) {
        return 75 * Math.pow(x, 2) - 12 * x + 7;
    }

    public static double fSeg(double x) {
        return 150 * x - 12;
    }

    public static double fTer(double x) {
        return 150;
    }
}