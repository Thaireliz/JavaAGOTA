import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class Modulo6Thaireliz {

    static final int MAX_OPERACIONES = 100;
    static String[] historialResultados = new String[MAX_OPERACIONES];
    static int contador = 0;

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
            System.out.println("6. Ver historial de resultados");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            opcionFigura = leerEntero(scanner);

            if (opcionFigura >= 1 && opcionFigura <= 5) {
                System.out.println("\n¿Qué desea calcular?");
                System.out.println("1. Área");
                System.out.println("2. Perímetro");
                System.out.print("Ingrese su opción: ");
                int opcionOperacion = leerEntero(scanner);

                double resultado = calcular(opcionFigura, opcionOperacion, scanner);
                if (resultado >= 0) {
                    String nombreFigura = obtenerNombreFigura(opcionFigura);
                    String tipoOperacion = (opcionOperacion == 1) ? "Área" : "Perímetro";
                    String mensaje = tipoOperacion + " del " + nombreFigura + " = " + String.format("%.2f", resultado);
                    System.out.println("\n✅ Resultado: " + mensaje);

                    if (contador < MAX_OPERACIONES) {
                        historialResultados[contador++] = mensaje;
                    } else {
                        System.out.println("⚠️ Historial lleno. No se guardarán más resultados.");
                    }
                } else {
                    System.out.println("❌ Opción de operación inválida.");
                }

                pausa(scanner);

            } else if (opcionFigura == 6) {
                mostrarHistorial();
                pausa(scanner);
            } else if (opcionFigura != 0) {
                System.out.println("❌ Opción inválida. Intente nuevamente.");
                pausa(scanner);
            }

        } while (opcionFigura != 0);

        System.out.println("👋 ¡Gracias por usar la calculadora!");
        scanner.close();
    }

    public static void limpiarPantalla() {
        for (int i = 0; i < 30; i++) System.out.println();
    }

    public static void pausa(Scanner scanner) {
        System.out.print("\nPresione ENTER para continuar...");
        scanner.nextLine(); // limpiar buffer
        scanner.nextLine();
    }

    public static int leerEntero(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next(); // limpiar entrada inválida
                System.out.print("❌ Entrada no válida. Ingrese un número entero: ");
            }
        }
    }

    public static double leerDouble(Scanner scanner, String mensaje) {
        double valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextDouble();
                if (valor <= 0) {
                    System.out.println("⚠️ El valor debe ser mayor que cero.");
                } else {
                    return valor;
                }
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("❌ Entrada no válida. Ingrese un número válido.");
            }
        }
    }

    public static double calcular(int figura, int operacion, Scanner scanner) {
        switch (figura) {
            case 1: // Círculo
                double radio = leerDouble(scanner, "Ingrese el radio del círculo: ");
                return (operacion == 1) ? Math.PI * Math.pow(radio, 2)
                        : (operacion == 2) ? 2 * Math.PI * radio : -1;

            case 2: // Cuadrado
                double lado = leerDouble(scanner, "Ingrese la longitud de un lado del cuadrado: ");
                return (operacion == 1) ? Math.pow(lado, 2)
                        : (operacion == 2) ? 4 * lado : -1;

            case 3: // Triángulo
                if (operacion == 1) {
                    double base = leerDouble(scanner, "Ingrese la base del triángulo: ");
                    double altura = leerDouble(scanner, "Ingrese la altura del triángulo: ");
                    return 0.5 * base * altura;
                } else if (operacion == 2) {
                    double l1 = leerDouble(scanner, "Ingrese el lado 1 del triángulo: ");
                    double l2 = leerDouble(scanner, "Ingrese el lado 2 del triángulo: ");
                    double l3 = leerDouble(scanner, "Ingrese el lado 3 del triángulo: ");
                    return l1 + l2 + l3;
                }
                break;

            case 4: // Rectángulo
                double largo = leerDouble(scanner, "Ingrese la longitud (largo) del rectángulo: ");
                double ancho = leerDouble(scanner, "Ingrese el ancho del rectángulo: ");
                return (operacion == 1) ? largo * ancho
                        : (operacion == 2) ? 2 * (largo + ancho) : -1;

            case 5: // Pentágono
                double ladoPent = leerDouble(scanner, "Ingrese la longitud de un lado del pentágono: ");
                if (operacion == 1) {
                    double apotema = leerDouble(scanner, "Ingrese el apotema del pentágono: ");
                    return 0.5 * 5 * ladoPent * apotema;
                } else if (operacion == 2) {
                    return 5 * ladoPent;
                }
                break;
        }
        return -1;
    }

    public static String obtenerNombreFigura(int figura) {
        switch (figura) {
            case 1: return "círculo";
            case 2: return "cuadrado";
            case 3: return "triángulo";
            case 4: return "rectángulo";
            case 5: return "pentágono";
            default: return "figura";
        }
    }

    public static void mostrarHistorial() {
        System.out.println("\n📚 Historial de Resultados:");
        if (contador == 0) {
            System.out.println("No se han realizado cálculos todavía.");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println((i + 1) + ". " + historialResultados[i]);
            }
        }
    }
}
