package com.mycompany.conversiones;

import java.util.Scanner;

public class OperacionesBinarias {
    public static void operar(Scanner scanner) {
        int opcion;
        do {
            System.out.println("=== OPERACIONES BINARIAS ===");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Raiz cuadrada");
            System.out.println("6. Volver al menu principal");
            System.out.println("============================");
            System.out.print("Seleccione operacion: ");
            
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch(opcion) {
                case 1:
                    operarBinario(scanner, "+");
                    break;
                case 2:
                    operarBinario(scanner, "-");
                    break;
                case 3:
                    operarBinario(scanner, "*");
                    break;
                case 4:
                    operarBinario(scanner, "/");
                    break;
                case 5:
                    raizBinaria(scanner);
                    break;
                case 6:
                    System.out.println("============================");
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion no valida!");
            }
        } while(opcion != 6);
    }
    
    private static void operarBinario(Scanner scanner, String operador) {
        System.out.println("=== OPERACION BINARIA " + operador + " ===");
        
        int num1 = obtenerYConvertir(scanner, "Ingrese primer binario: ");
        int num2 = obtenerYConvertir(scanner, "Ingrese segundo binario: ");
        
        if(num1 == -1 || num2 == -1) return;
        
        int resultado = 0;
        switch(operador) {
            case "+": resultado = num1 + num2; break;
            case "-": resultado = num1 - num2; break;
            case "*": resultado = num1 * num2; break;
            case "/": 
                if(num2 == 0) {
                    System.out.println("Error: Division por cero!");
                    return;
                }
                resultado = num1 / num2;
                break;
        }
        
        System.out.println("Resultado: " + DecimalBinario.convertirManual(resultado));
        esperarEnter(scanner);
    }
    
    private static void raizBinaria(Scanner scanner) {
        System.out.println("\n=== RAÍZ CUADRADA BINARIA ===");
        int num = obtenerYConvertir(scanner, "Ingrese numero binario: ");
        
        if(num < 0) {
            System.out.println("Error: Numero negativo!");
            return;
        }
        
        double raiz = Math.sqrt(num);
        if(raiz == (int)raiz) {
            System.out.println("Raiz exacta: " + DecimalBinario.convertirManual((int)raiz));
        } else {
            System.out.println("No tiene raiz exacta!");
        }
        esperarEnter(scanner);
    }
    
    private static int obtenerYConvertir(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        String input = scanner.nextLine();
        
        if(!input.matches("[01]+")) {
            System.out.println("Error: Binario no valido!");
            return -1;
        }
        return BinarioDecimal.convertirManual(input);
    }
    
    private static void esperarEnter(Scanner scanner) {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}