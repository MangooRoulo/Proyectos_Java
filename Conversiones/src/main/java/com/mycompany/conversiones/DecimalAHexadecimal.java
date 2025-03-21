package com.mycompany.conversiones;

import java.util.Scanner;

public class DecimalAHexadecimal {
    public static void convertir(Scanner scanner) {
        System.out.println("\n=== DECIMAL A HEXADECIMAL ===");
        String decimalStr = obtenerDecimal(scanner);
        
        if(validarDecimal(decimalStr)) {
            int decimal = Integer.parseInt(decimalStr);
            mostrarResultados(decimal);
        }
        
        esperarEnter(scanner);
    }
    
    private static String obtenerDecimal(Scanner scanner) {
        System.out.print("Ingrese numero decimal: ");
        return scanner.nextLine();
    }
    
    private static boolean validarDecimal(String decimalStr) {
        if(!decimalStr.matches("\\d+")) {
            System.out.println("Error: No es un decimal valido!");
            return false;
        }
        return true;
    }
    
    private static void mostrarResultados(int decimal) {
        System.out.println("Metodo nativo: " + Integer.toHexString(decimal).toUpperCase());
        System.out.println("Algoritmo manual: " + convertirManual(decimal));
    }
    
    public static String convertirManual(int decimal) {
        if (decimal == 0) return "0";
        char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        StringBuilder hex = new StringBuilder();
        while(decimal > 0) {
            hex.insert(0, hexChars[decimal % 16]);
            decimal /= 16;
        }
        return hex.toString();
    }
    
    private static void esperarEnter(Scanner scanner) {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}