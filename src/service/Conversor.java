package service;

import sources.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import exception.ConversorException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public Convert convertirMoneda(ApiOptions opcion, double monto, String apiKey) {
        try {
            URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + opcion.getBase() + "/" + opcion.getCambio() + "/" + monto);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);
                double total = jsonResponse.get("conversion_result").getAsDouble();

                return new Convert(opcion.getBase(), opcion.getCambio(), total);
            } else {
                throw new ConversorException("Error al convertir, código de estado: " + response.statusCode());
            }
        } catch (Exception e) {
            throw new ConversorException("Error en la conversión: " + e.getMessage());
        }
    }
    }