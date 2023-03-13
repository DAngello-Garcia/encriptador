package com.example.demo.util;

public class Encriptador {
    public static String encriptar(String mensaje) {
        char [] nuevo = mensaje.toCharArray();
        for(int i = 0; i < nuevo.length; i++) {
            nuevo[i]+=3;
        }
        return String.valueOf(nuevo);
    }

    public static String desencriptar(String mensaje) {
        char [] nuevo = mensaje.toCharArray();
        for(int i = 0; i < nuevo.length; i++) {
            nuevo[i]-=3;
        }
        return String.valueOf(nuevo);
    }
}
