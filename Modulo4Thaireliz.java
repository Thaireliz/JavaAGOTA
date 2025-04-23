import java.util.Scanner;

public class Modulo4Thaireliz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Datos del visitante
        System.out.print("Nombre completo: ");
        String nombreVisitante = scanner.nextLine();

        System.out.print("Inicial del segundo nombre: ");
        char inicialSegundoNombre = scanner.next().charAt(0);

        System.out.print("Edad: ");
        byte edad = scanner.nextByte();

        System.out.print("Número de identificación: ");
        int numeroIdentificacion = scanner.nextInt();

        System.out.print("Teléfono de contacto (sin +): ");
        long telefonoContacto = scanner.nextLong();

        System.out.print("Altura en metros (ej: 1.75): ");
        double altura = scanner.nextDouble();

        System.out.print("Temperatura corporal (ej: 36.6): ");
        float temperaturaCorporal = scanner.nextFloat();

        System.out.print("¿Tiene permiso para ingresar? (true/false): ");
        boolean tienePermiso = scanner.nextBoolean();

        // Registro de visitas
        short totalVisitas = 0;
        int sumaDuraciones = 0;

        System.out.println("\n--- Registro de visitas para la semana ---");
        for (int i = 0; i < 7; i++) {
            System.out.print("¿Cuántas visitas el día " + (i + 1) + "? ");
            byte visitasDelDia = scanner.nextByte();

            for (int j = 0; j < visitasDelDia; j++) {
                System.out.print("  Duración en minutos de la visita " + (j + 1) + ": ");
                short duracion = scanner.nextShort();
                sumaDuraciones += duracion;
                totalVisitas++;
            }
        }

        // Cálculo de promedios
        double promedioEstadia = (totalVisitas > 0) ? (double) sumaDuraciones / totalVisitas : 0.0;
        boolean esMayorEdad = edad >= 18;

        // Resultados
        System.out.println("\n--- Resumen de la Semana ---");
        System.out.println("Visitante: " + nombreVisitante);
        System.out.println("Total de visitas: " + totalVisitas);
        System.out.printf("Tiempo promedio de estadía: %.2f minutos%n", promedioEstadia);
        System.out.println("¿Es mayor de edad?: " + (esMayorEdad ? "Sí" : "No"));

        scanner.close();
    }
}