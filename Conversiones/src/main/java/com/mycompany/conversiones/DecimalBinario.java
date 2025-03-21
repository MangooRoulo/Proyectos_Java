package com.mycompany.conversiones;
import java.util.Scanner;

public class DecimalBinario {
    public static void convertir(Scanner scanner) {
        System.out.println("\n=== DECIMAL A BINARIO ===");
        int numero = obtenerNumero(scanner);
        
        if(numero != -1) {
            mostrarResultados(numero);
        }
        
        esperarEnter(scanner);
    }
    
    private static int obtenerNumero(Scanner scanner) {
        System.out.print("Ingrese numero decimal: ");
        String input = scanner.nextLine();
        
        try {
            int num = Integer.parseInt(input);
            if(num < 0) {
                System.out.println("Error: Solo numeros positivos!");
                return -1;
            }
            return num;
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un numero valido!");
            return -1;
        }
    }
    
    private static void mostrarResultados(int numero) {
        System.out.println("Metodo nativo: " + Integer.toBinaryString(numero));
        System.out.println("Algoritmo manual: " + convertirManual(numero));
    }
    
    public static String convertirManual(int numero) {
        if(numero == 0) return "0";
        StringBuilder binario = new StringBuilder();
        while(numero > 0) {
            binario.insert(0, numero % 2);
            numero /= 2;
        }
        return binario.toString();
    }
    
    private static void esperarEnter(Scanner scanner) {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine(); // Solo necesita una lectura
    }
}