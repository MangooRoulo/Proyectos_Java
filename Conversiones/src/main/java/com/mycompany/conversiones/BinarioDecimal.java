package com.mycompany.conversiones;

import java.util.Scanner;

public class BinarioDecimal {
    public static void convertir(Scanner scanner) {
        System.out.println("\n=== BINARIO A DECIMAL ===");
        String binario = obtenerBinario(scanner);
        
        if(validarBinario(binario)) {
            mostrarResultados(binario);
        }
        
        esperarEnter(scanner);
    }
    
    private static String obtenerBinario(Scanner scanner) {
        System.out.print("Ingrese numero binario: ");
        return scanner.nextLine();
    }
    
    private static boolean validarBinario(String binario) {
        if(!binario.matches("[01]+")) {
            System.out.println("Error: No es un binario valido!");
            return false;
        }
        return true;
    }
    
    private static void mostrarResultados(String binario) {
        System.out.println("Metodo nativo: " + Integer.parseInt(binario, 2));
        System.out.println("Algoritmo manual: " + convertirManual(binario));
    }
    
    public static int convertirManual(String binario) {
        int decimal = 0;
        int longitud = binario.length();
        
        for(int i = 0; i < longitud; i++) {
            int bit = Character.getNumericValue(binario.charAt(i));
            decimal += bit * Math.pow(2, longitud - 1 - i);
        }
        return decimal;
    }
    
    private static void esperarEnter(Scanner scanner) {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}