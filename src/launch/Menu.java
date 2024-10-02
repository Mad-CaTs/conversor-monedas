package launch;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sources.ApiOptions;
import service.Conversor;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public void mostrarMenu(String apiKey) {
        Scanner consola = new Scanner(System.in);
        boolean salir = false;

        try {
            List<ApiOptions> opciones = cargarOpciones();
            mostrarOpciones(opciones);

            while (!salir) {
                System.out.print("Escriba una opción válida o CERO para salir: ");
                int opcionElegida = consola.nextInt();

                ApiOptions opcionSeleccionada = opciones.stream()
                        .filter(op -> op.getId() == opcionElegida)
                        .findFirst()
                        .orElse(null);

                if (opcionSeleccionada != null) {
                    if (opcionElegida == 0) {
                        System.out.println("¡Nos vemos, adiós!");
                        salir = true;
                    } else {
                        Seleccion procesarSeleccion = new Seleccion();
                        procesarSeleccion.manejarSeleccion(opcionSeleccionada, apiKey);
                    }
                } else {
                    System.out.println("Opción inválida, vuelve a digitar");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar el menú: " + e.getMessage());
        }
    }

    private List<ApiOptions> cargarOpciones() throws Exception {
        InputStreamReader reader = new InputStreamReader(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("util/file.json"))
        );
        Gson gson = new Gson();
        Type type = new TypeToken<List<ApiOptions>>() {}.getType();
        return gson.fromJson(reader, type);
    }

    private void mostrarOpciones(List<ApiOptions> opciones) {
        System.out.println("********************************************************");
        System.out.println("**** Conversor de Monedas ****");
        opciones.forEach(opcion -> System.out.println(opcion));
        System.out.println("********************************************************");
    }
}
