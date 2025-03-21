package com.mycompany.conversiones;
import java.util.Scanner;

public class Conversiones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            mostrarMenu();
            int opcion = obtenerOpcion(scanner);
            
            switch(opcion) {
                case 1:
                    DecimalBinario.convertir(scanner);
                    break;
                case 2:
                    BinarioDecimal.convertir(scanner);
                    break;
                case 3:
                    DecimalAOctal.convertir(scanner);
                    break;
                case 4:
                    OctalADecimal.convertir(scanner);
                    break;
                case 5:
                    DecimalAHexadecimal.convertir(scanner);
                    break;
                case 6:
                    HexadecimalADecimal.convertir(scanner);
                    break;
               case 7:
                    OperacionesBinarias.operar(scanner);
                    break;
                case 8:
                    OperacionesDecimales.operar(scanner);
                    break;
                case 9:
                    OperacionesOctales.operar(scanner);
                    break;
                case 10:
                    OperacionesHexadecimales.operar(scanner);
                    break;
                case 11:
                    salirPrograma(scanner);
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=======Menu Principal=======");
        System.out.println("1. Decimal a Binario");
        System.out.println("2. Binario a Decimal");
        System.out.println("3. Decimal a Octal");
        System.out.println("4. Octal a Decimal");
        System.out.println("5. Decimal a Hexadecimal");
        System.out.println("6. Hexadecimal a Decimal");
        System.out.println("7. Operaciones Binarias");
        System.out.println("8. Operaciones Decimales");
        System.out.println("9. Operaciones Octales");
        System.out.println("10. Operaciones Hexadecimales");
        System.out.println("11. Salir");
        System.out.println("============================");
        System.out.print("Seleccione opcion: ");
    }
    
    private static int obtenerOpcion(Scanner scanner) {
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
    
    private static void salirPrograma(Scanner scanner) {
        System.out.println("Saliendo del programa...");
        scanner.close();
        System.exit(0);
    }
    
    private static void clearConsole() {
    try {
        final String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    } catch (final Exception e) {
        System.out.println("\n".repeat(50));
    }
}
}