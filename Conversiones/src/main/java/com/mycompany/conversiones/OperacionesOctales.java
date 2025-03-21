package com.mycompany.conversiones;

import java.util.Scanner;

public class OperacionesOctales {
    public static void operar(Scanner scanner) {
        int opcion;
        do {
            System.out.println("=== OPERACIONES OCTALES ===");
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
                    operarOctal(scanner, "+");
                    break;
                case 2:
                    operarOctal(scanner, "-");
                    break;
                case 3:
                    operarOctal(scanner, "*");
                    break;
                case 4:
                    operarOctal(scanner, "/");
                    break;
                case 5:
                    raizOctal(scanner);
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
    
    private static void operarOctal(Scanner scanner, String operador) {
        System.out.println("\n=== OPERACION OCTAL " + operador + " ===");
        
        int num1 = obtenerYConvertir(scanner, "Ingrese primer octal: ");
        int num2 = obtenerYConvertir(scanner, "Ingrese segundo octal: ");
        
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
        
        System.out.println("Resultado: " + DecimalAOctal.convertirManual(resultado));
        esperarEnter(scanner);
    }
    
    private static void raizOctal(Scanner scanner) {
        System.out.println("\n=== RAÍZ CUADRADA OCTAL ===");
        int num = obtenerYConvertir(scanner, "Ingrese numero octal: ");
        
        if(num < 0) {
            System.out.println("Error: Numero negativo!");
            return;
        }
        
        double raiz = Math.sqrt(num);
        if(raiz == (int)raiz) {
            System.out.println("Raiz exacta: " + DecimalAOctal.convertirManual((int)raiz));
        } else {
            System.out.println("No tiene raiz exacta!");
        }
        esperarEnter(scanner);
    }
    
    private static int obtenerYConvertir(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        String input = scanner.nextLine();
        
        if(!input.matches("[0-7]+")) {
            System.out.println("Error: Octal no valido!");
            return -1;
        }
        return OctalADecimal.convertirManual(input);
    }
    
    private static void esperarEnter(Scanner scanner) {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}