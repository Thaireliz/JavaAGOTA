public class Modulo3Thaireliz {
    public static void main(String[] args) {
        // Datos del visitante
        String nombreVisitante = "Ana Pérez";
        char inicialSegundoNombre = 'M';
        byte edad = 35;
        short numeroApartamentoVisitado = 205;
        int numeroIdentificacion = 123456789;
        long telefonoContacto = 50769874563L;
        float temperaturaCorporal = 36.5F;
        double altura = 1.68;
        boolean tienePermiso = true;

        // Imprimir
        System.out.println("--- Información del Visitante ---");
        System.out.println("Nombre completo: " + nombreVisitante);
        System.out.println("Inicial del segundo nombre: " + inicialSegundoNombre);
        System.out.println("Edad: " + edad);
        System.out.println("Número de apartamento visitado: " + numeroApartamentoVisitado);
        System.out.println("Número de identificación: " + numeroIdentificacion);
        System.out.println("Teléfono de contacto: +" + telefonoContacto);
        System.out.println("Temperatura corporal: " + temperaturaCorporal + " °C");
        System.out.println("Altura: " + altura + " metros");
        System.out.println("¿Tiene permiso para ingresar?: " + tienePermiso);
    }
}