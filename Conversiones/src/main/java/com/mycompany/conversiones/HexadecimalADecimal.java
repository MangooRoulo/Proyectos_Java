package com.mycompany.conversiones;

import java.util.Scanner;

public class HexadecimalADecimal {
    public static void convertir(Scanner scanner) {
        System.out.println("\n=== HEXADECIMAL A DECIMAL ===");
        String hex = obtenerHexadecimal(scanner);
        
        if(validarHexadecimal(hex)) {
            mostrarResultados(hex.toUpperCase());
        }
        
        esperarEnter(scanner);
    }
    
    private static String obtenerHexadecimal(Scanner scanner) {
        System.out.print("Ingrese numero hexadecimal: ");
        return scanner.nextLine();
    }
    
    private static boolean validarHexadecimal(String hex) {
        if(!hex.matches("[0-9A-Fa-f]+")) {
            System.out.println("Error: No es un hexadecimal valido!");
            return false;
        }
        return true;
    }
    
    private static void mostrarResultados(String hex) {
        System.out.println("Metodo nativo: " + Integer.parseInt(hex, 16));
        System.out.println("Algoritmo manual: " + convertirManual(hex));
    }
    
    public static int convertirManual(String hex) {
        hex = hex.toUpperCase();
        int decimal = 0;
        int longitud = hex.length();
        
        for(int i = 0; i < longitud; i++) {
            char c = hex.charAt(i);
            int valor = Character.isDigit(c) ? 
                Character.getNumericValue(c) : 
                (c - 'A' + 10);
                
            decimal += valor * Math.pow(16, longitud - 1 - i);
        }
        return decimal;
    }
    
    private static void esperarEnter(Scanner scanner) {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}