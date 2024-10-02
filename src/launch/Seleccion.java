package launch;

import service.Conversor;
import sources.ApiOptions;
import sources.Convert;

import java.util.Scanner;

public class Seleccion {
    public void manejarSeleccion(ApiOptions opcionSeleccionada, String apiKey) {
        Conversor convertirMoneda = new Conversor();
        realizarConversion(opcionSeleccionada, convertirMoneda, apiKey);
    }

    private void realizarConversion(ApiOptions opcion, Conversor convertirMoneda, String apiKey) {
        Scanner consola = new Scanner(System.in);

        try {
            System.out.print("Ingrese el valor a convertir: ");
            double monto = consola.nextDouble();

            if (monto <= 0) {
                System.out.println("El valor debe ser positivo.");
                return;
            }

            Convert resultado = convertirMoneda.convertirMoneda(opcion, monto, apiKey);
            mostrarResultado(resultado, monto);
        } catch (Exception e) {
            System.out.println("Error al procesar la conversión: " + e.getMessage());
        }
    }

    private void mostrarResultado(Convert resultado, double monto) {
        System.out.printf("Convertido: %.2f [%s] => %.2f [%s]%n",
                monto, resultado.getMonedaBase(), resultado.getMonedaTotal(), resultado.getMonedaCambio());
    }
}
