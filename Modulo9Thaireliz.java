import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

// Clase que extiende Thread para validar contraseñas
class ValidadorContrasena extends Thread {
    private String contrasena;

    public ValidadorContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public void run() {
        if (validar(contrasena)) {
            System.out.println("✅ Contraseña válida: " + contrasena);
        } else {
            System.out.println("❌ Contraseña inválida: " + contrasena);
        }
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

// Clase principal con el método main
public class Modulo9Thaireliz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Thread> hilos = new ArrayList<>();

        System.out.println("Ingrese contraseñas a validar (escriba 'fin' para terminar):");

        while (true) {
            System.out.print("> ");
            String entrada = sc.nextLine();
            if (entrada.equalsIgnoreCase("fin")) break;

            ValidadorContrasena hilo = new ValidadorContrasena(entrada);
            hilos.add(hilo);
            hilo.start();
        }

        // Esperar que todos los hilos terminen
        for (Thread t : hilos) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Error esperando el hilo: " + e.getMessage());
            }
        }

        System.out.println("Validación finalizada.");
    }
}
