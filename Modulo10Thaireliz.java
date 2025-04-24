import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import java.util.concurrent.CopyOnWriteArrayList;

class ValidadorContrasena extends Thread {
    private String contrasena;
    private List<String> registro;

    public ValidadorContrasena(String contrasena, List<String> registro) {
        this.contrasena = contrasena;
        this.registro = registro;
    }

    @Override
    public void run() {
        boolean esValida = validar(contrasena);
        String resultado = (esValida ? "✅ VÁLIDA" : "❌ INVÁLIDA") + " - " + contrasena;
        System.out.println(resultado);
        registro.add(resultado);
    }

    private boolean validar(String pass) {
        if (pass.length() < 8) return false;

        Pattern especial = Pattern.compile("[^a-zA-Z0-9]");
        Pattern mayusculas = Pattern.compile("[A-Z]");
        Pattern minusculas = Pattern.compile("[a-z]");
        Pattern numeros = Pattern.compile("\\d");

        Matcher mEspecial = especial.matcher(pass);
        Matcher mMayusculas = mayusculas.matcher(pass);
        Matcher mMinusculas = minusculas.matcher(pass);
        Matcher mNumeros = numeros.matcher(pass);

        int countMayus = 0, countMinus = 0;
        while (mMayusculas.find()) countMayus++;
        while (mMinusculas.find()) countMinus++;

        return mEspecial.find() && mNumeros.find() && countMayus >= 2 && countMinus >= 3;
    }
}

public class Modulo10Thaireliz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> registroResultados = new CopyOnWriteArrayList<>();
        List<Thread> hilos = new ArrayList<>();

        System.out.println("Ingrese contraseñas a validar (escriba 'fin' para terminar):");

        while (true) {
            System.out.print("> ");
            String entrada = sc.nextLine();
            if (entrada.equalsIgnoreCase("fin")) break;

            Thread hilo = new ValidadorContrasena(entrada, registroResultados);
            hilos.add(hilo);
            hilo.start();
        }

        // Esperar todos los hilos
        hilos.forEach(h -> {
            try {
                h.join();
            } catch (InterruptedException e) {
                System.out.println("Error esperando hilo: " + e.getMessage());
            }
        });

        // Guardar los resultados en el archivo
        Path rutaArchivo = Paths.get("registro_contrasenas.txt");
        try {
            Files.write(rutaArchivo, registroResultados);
            System.out.println("\n📁 Resultados guardados en 'registro_contrasenas.txt'");
        } catch (IOException e) {
            System.out.println("Error escribiendo archivo: " + e.getMessage());
        }

        System.out.println("Validación finalizada.");
    }
}
