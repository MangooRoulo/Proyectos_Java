package com.mycompany.conversiones;

import java.util.Scanner;

public class OperacionesDecimales {
    public static void operar(Scanner scanner) {
        int opcion;
        do {
            System.out.println("=== OPERACIONES DECIMALES ===");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Raiz cuadrada");
            System.out.println("5. Volver al menu principal");
            System.out.println("============================");
            System.out.print("Seleccione operacion: ");
            
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch(opcion) {
                case 1:
                    operarDecimal(scanner, "+");
                    break;
                case 2:
                    operarDecimal(scanner, "-");
                    break;
                case 3:
                    operarDecimal(scanner, "*");
                    break;
                case 4:
                    operarDecimal(scanner, "/");
                    break;
                case 5:
                    raizDecimal(scanner);
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
    
    private static void operarDecimal(Scanner scanner, String operador) {
        System.out.println("\n=== OPERACION DECIMAL " + operador + " ===");
        
        double num1 = obtenerDecimal(scanner, "Ingrese primer numero: ");
        double num2 = obtenerDecimal(scanner, "Ingrese segundo numero: ");
        
        if(Double.isNaN(num1) || Double.isNaN(num2)) return;
        
        double resultado = 0;
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
        
        System.out.println("Resultado: " + resultado);
        esperarEnter(scanner);
    }
        
    private static void raizDecimal(Scanner scanner) {
        System.out.println("\n=== RAÍZ CUADRADA DECIMAL ===");
        double num = obtenerDecimal(scanner, "Ingrese numero: ");
        
        if(num < 0) {
            System.out.println("Error: Numero negativo!");
            return;
        }
        
        System.out.println("Resultado: " + Math.sqrt(num));
        esperarEnter(scanner);
    }
    
    private static double obtenerDecimal(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        String input = scanner.nextLine();
        
        if(!input.matches("-?\\d+(\\.\\d+)?")) {
            System.out.println("Error: Numero no valido!");
            return Double.NaN;
        }
        return Double.parseDouble(input);
    }
    
        private static void esperarEnter(Scanner scanner) {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}