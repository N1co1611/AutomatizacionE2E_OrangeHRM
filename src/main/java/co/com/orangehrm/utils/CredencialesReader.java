package co.com.orangehrm.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;

public class CredencialesReader {

    private static final String CREDENCIALES_PATH = "/data/credenciales.json";

    public static JsonObject getCredencialesPorRol(String rol) {
        try {
            InputStream inputStream = CredencialesReader.class.getResourceAsStream(CREDENCIALES_PATH);
            JsonObject root = JsonParser.parseReader(new InputStreamReader(inputStream)).getAsJsonObject();
            JsonObject perfil = root.getAsJsonObject(rol.toLowerCase());

            if (perfil == null) {
                throw new RuntimeException("No se encontraron credenciales para el rol: " + rol);
            }

            return perfil;
        } catch (Exception e) {
            throw new RuntimeException("Error al leer las credenciales: " + e.getMessage(), e);
        }
    }
}
