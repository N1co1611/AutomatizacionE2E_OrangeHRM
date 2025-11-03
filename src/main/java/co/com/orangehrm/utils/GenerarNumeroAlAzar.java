package co.com.orangehrm.utils;

import java.util.Random;

public class GenerarNumeroAlAzar {

    public static String generar(int n) {

        Random random = new Random();

        StringBuilder numero = new StringBuilder();
        numero.append(random.nextInt(9) + 1);

        for (int i = 1; i < n; i++) {
            numero.append(random.nextInt(10));
        }

        return numero.toString();
    }

}
