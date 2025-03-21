package com.mycompany.conversiones;

import java.util.Scanner;

public class OctalADecimal {
    public static void convertir(Scanner scanner) {
        System.out.println("\n=== OCTAL A DECIMAL ===");
        String octal = obtenerOctal(scanner);
        
        if(validarOctal(octal)) {
            mostrarResultados(octal);
        }
        
        esperarEnter(scanner);
    }
    
    private static String obtenerOctal(Scanner scanner) {
        System.out.print("Ingrese numero octal: ");
        return scanner.nextLine();
    }
    
    private static boolean validarOctal(String octal) {
        if(!octal.matches("[0-7]+")) {
            System.out.println("Error: No es un octal valido!");
            return false;
        }
        return true;
    }
    
    private static void mostrarResultados(String octal) {
        System.out.println("Metodo nativo: " + Integer.parseInt(octal, 8));
        System.out.println("Algoritmo manual: " + convertirManual(octal));
    }
    
    public static int convertirManual(String octal) {
        int decimal = 0;
        int longitud = octal.length();
        
        for(int i = 0; i < longitud; i++) {
            int digito = Character.getNumericValue(octal.charAt(i));
            decimal += digito * Math.pow(8, longitud - 1 - i);
        }
        return decimal;
    }
    
    private static void esperarEnter(Scanner scanner) {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}