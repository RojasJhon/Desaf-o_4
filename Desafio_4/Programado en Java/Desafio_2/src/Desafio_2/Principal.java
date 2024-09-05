package Desafio_2;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 2.5;
		double a = 1;
		int n = 4;
		double f_x = Math.log(x);
		double f_a = Math.log(a);
		double error = Math.abs((f_x - taylor(x, a, n)) / f_x * 100);
		System.out.println("Aproximación de Taylor: " + taylor(x, a, n));
		System.out.println("Valor real: " + f_x);
		System.out.println("Error relativo porcentual: " + error + "%");
	}

	public static double taylor(double x, double a, int n) {
		double resultado = 0;
		for (int i = 0; i <= n; i++) {
			resultado += (Math.pow(x - a, i) / factorial(i)) * derivada(a, i);
		}
		return resultado;
	}

	public static double derivada(double x, int n) {
		if (n == 0) {
			return 1 / x;
		} else {
			return (-1) * Math.pow(-1, n) * factorial(n - 1) / Math.pow(x, n);
		}
	}

	public static long factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
}
