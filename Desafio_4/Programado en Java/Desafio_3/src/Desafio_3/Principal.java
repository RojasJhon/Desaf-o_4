package Desafio_3;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Datos del problema
		double B = 20; // Ancho del canal (m)
		double H = 0.3; // Profundidad del canal (m)
		double n = 0.03; // Coeficiente de rugosidad
		double S = 0.0003; // Pendiente del canal
		
		// Rangos de error
		double error_n = 0.1; // Error en el coeficiente de rugosidad
		double error_S = 0.1; // Error en la pendiente
		
		// Cálculo del flujo usando los valores nominales
		double Q = calcularFlujo(B, H, n, S);
		
		// Cálculo del flujo con el error en el coeficiente de rugosidad
		double Q_n_mas = calcularFlujo(B, H, n*(1+error_n), S);
		double Q_n_menos = calcularFlujo(B, H, n*(1-error_n), S);
		
		// Cálculo del flujo con el error en la pendiente
		double Q_S_mas = calcularFlujo(B, H, n, S*(1+error_S));
		double Q_S_menos = calcularFlujo(B, H, n, S*(1-error_S));
		
		// Cálculo de la sensibilidad
		double sensibilidad_n = (Q_n_mas - Q_n_menos) / (2 * Q);
		double sensibilidad_S = (Q_S_mas - Q_S_menos) / (2 * Q);
		
		// Impresión de los resultados
		System.out.println("Flujo nominal: " + Q);
		System.out.println("Sensibilidad del coeficiente de rugosidad: " + sensibilidad_n);
		System.out.println("Sensibilidad de la pendiente: " + sensibilidad_S);
		
		// Conclusión
		System.out.println("\nLa variable que se debería intentar medir para una mejor precisión es la pendiente.");
	}
	
	// Función para calcular el flujo
	public static double calcularFlujo(double B, double H, double n, double S) {
		double Q = (1 / n) * Math.pow(B * H, 5 / 3) * Math.pow(B + 2 * H, -2 / 3) * Math.sqrt(S);
		return Q;
	}

}