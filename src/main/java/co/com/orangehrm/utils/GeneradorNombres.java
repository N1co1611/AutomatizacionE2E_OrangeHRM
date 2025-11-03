package co.com.orangehrm.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class GeneradorNombres {

    private static final String NOMBRES_PATH = "/data/nombres.json";

    public static JsonObject  generarNombreCompleto() {
        try {
            InputStream inputStream = GeneradorNombres.class.getResourceAsStream(NOMBRES_PATH);
            assert inputStream != null;

            JsonObject root = JsonParser.parseReader(new InputStreamReader(inputStream)).getAsJsonObject();
            JsonArray nombres = root.getAsJsonArray("nombres");
            JsonArray apellidos = root.getAsJsonArray("apellidos");

            Random random = new Random();
            String nombre1 = nombres.get(random.nextInt(nombres.size())).getAsString();
            String nombre2 = nombres.get(random.nextInt(nombres.size())).getAsString();
            String apellido = apellidos.get(random.nextInt(apellidos.size())).getAsString();

            JsonObject resultado = new JsonObject();
            resultado.addProperty("primerNombre", nombre1);
            resultado.addProperty("segundoNombre", nombre2);
            resultado.addProperty("apellido", apellido);

            return resultado;
        } catch (Exception e) {
            throw new RuntimeException("Error al leer nombres.json: " + e.getMessage(), e);
        }
    }

}
