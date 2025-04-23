import java.util.Scanner;
import java.lang.Math;

public class Modulo5Thaireliz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionFigura;

        do {
            limpiarPantalla();

            System.out.println("=== Calculadora de Área y Perímetro ===");
            System.out.println("Seleccione la figura que desea calcular:");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcionFigura = scanner.nextInt();

            if (opcionFigura >= 1 && opcionFigura <= 5) {
                System.out.println("\n¿Qué desea calcular?");
                System.out.println("1. Área");
                System.out.println("2. Perímetro");
                System.out.print("Ingrese su opción: ");
                int opcionOperacion = scanner.nextInt();

                double resultado = calcular(opcionFigura, opcionOperacion, scanner);
                if (resultado >= 0) {
                    String tipo = (opcionOperacion == 1) ? "área" : "perímetro";
                    System.out.printf("\n✅ El %s es: %.2f\n", tipo, resultado);
                } else {
                    System.out.println("❌ Opción de operación inválida.");
                }

                System.out.print("\nPresione ENTER para continuar...");
                scanner.nextLine(); // limpiar buffer
                scanner.nextLine(); // esperar ENTER
            } else if (opcionFigura != 0) {
                System.out.println("❌ Opción inválida. Intente nuevamente.");
                System.out.print("\nPresione ENTER para continuar...");
                scanner.nextLine();
                scanner.nextLine();
            }

        } while (opcionFigura != 0);

        System.out.println("👋 ¡Gracias por usar la calculadora!");
        scanner.close();
    }


    public static void limpiarPantalla() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public static double calcular(int figura, int operacion, Scanner scanner) {
        switch (figura) {
            case 1: // Círculo
                System.out.println("\nHa elegido CÍRCULO.");
                System.out.print("Ingrese el radio del círculo (ej: 5.5): ");
                double radio = scanner.nextDouble();
                return (operacion == 1) ? Math.PI * Math.pow(radio, 2)
                        : (operacion == 2) ? 2 * Math.PI * radio : -1;

            case 2: // Cuadrado
                System.out.println("\nHa elegido CUADRADO.");
                System.out.print("Ingrese la longitud de un lado (ej: 4): ");
                double lado = scanner.nextDouble();
                return (operacion == 1) ? Math.pow(lado, 2)
                        : (operacion == 2) ? 4 * lado : -1;

            case 3: // Triángulo
                System.out.println("\nHa elegido TRIÁNGULO.");
                if (operacion == 1) {
                    System.out.print("Ingrese la base del triángulo (ej: 6): ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingrese la altura del triángulo (ej: 4): ");
                    double altura = scanner.nextDouble();
                    return 0.5 * base * altura;
                } else if (operacion == 2) {
                    System.out.print("Ingrese el lado 1 del triángulo (ej: 3): ");
                    double l1 = scanner.nextDouble();
                    System.out.print("Ingrese el lado 2 del triángulo (ej: 4): ");
                    double l2 = scanner.nextDouble();
                    System.out.print("Ingrese el lado 3 del triángulo (ej: 5): ");
                    double l3 = scanner.nextDouble();
                    return l1 + l2 + l3;
                }
                break;

            case 4: // Rectángulo
                System.out.println("\nHa elegido RECTÁNGULO.");
                System.out.print("Ingrese la longitud (ej: 8): ");
                double largo = scanner.nextDouble();
                System.out.print("Ingrese el ancho (ej: 4): ");
                double ancho = scanner.nextDouble();
                return (operacion == 1) ? largo * ancho
                        : (operacion == 2) ? 2 * (largo + ancho) : -1;

            case 5: // Pentágono
                System.out.println("\nHa elegido PENTÁGONO REGULAR.");
                System.out.print("Ingrese la longitud de un lado (ej: 5): ");
                double ladoPent = scanner.nextDouble();
                if (operacion == 1) {
                    System.out.print("Ingrese el apotema (ej: 3.4): ");
                    double apotema = scanner.nextDouble();
                    return 0.5 * 5 * ladoPent * apotema;
                } else if (operacion == 2) {
                    return 5 * ladoPent;
                }
                break;
        }
        return -1;
    }
}
