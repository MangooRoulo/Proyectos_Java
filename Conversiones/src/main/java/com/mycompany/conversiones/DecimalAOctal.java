package com.mycompany.conversiones;

import java.util.Scanner;

public class DecimalAOctal {
    public static void convertir(Scanner scanner) {
        System.out.println("\n=== DECIMAL A OCTAL ===");
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
        System.out.println("Metodo nativo: " + Integer.toOctalString(decimal));
        System.out.println("Algoritmo manual: " + convertirManual(decimal));
    }
    
    public static String convertirManual(int decimal) {
        if (decimal == 0) return "0";
        StringBuilder octal = new StringBuilder();
        while(decimal > 0) {
            octal.insert(0, decimal % 8);
            decimal /= 8;
        }
        return octal.toString();
    }
    
    private static void esperarEnter(Scanner scanner) {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}