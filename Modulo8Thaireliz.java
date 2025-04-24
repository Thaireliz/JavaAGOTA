
interface OperacionGeometrica {
    double calcularPerimetro();
}

abstract class Figura implements OperacionGeometrica {
}

class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double calcularPerimetro() {
        return 4 * lado;
    }
}

class Triangulo extends Figura {
    private double base, altura, l1, l2, l3;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Triangulo(double l1, double l2, double l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    public double calcularPerimetro() {
        if (l1 != 0 && l2 != 0 && l3 != 0) {
            return l1 + l2 + l3;
        }
        return 0;
    }
}

class Rectangulo extends Figura {
    private double largo, ancho;

    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    public double calcularPerimetro() {
        return 2 * (largo + ancho);
    }
}

class Pentagono extends Figura {
    private double lado, apotema;

    public Pentagono(double lado, double apotema) {
        this.lado = lado;
        this.apotema = apotema;
    }

    public double calcularPerimetro() {
        return 5 * lado;
    }
}

// Clase para calcular potencias matemáticas
class Potencia {
    public static long calcular(int base, int exponente) {
        long resultado = 1;
        for (int i = 1; i <= exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }
}

// Clase principal
public class Modulo8Thaireliz {
    public static void main(String[] args) {
        Figura circulo = new Circulo(5);
        Figura cuadrado = new Cuadrado(4);
        Figura triangulo = new Triangulo(3, 4, 5);
        Figura rectangulo = new Rectangulo(2, 6);
        Figura pentagono = new Pentagono(3, 5);

        System.out.println("Perímetro del círculo: " + circulo.calcularPerimetro());
        System.out.println("Perímetro del cuadrado: " + cuadrado.calcularPerimetro());
        System.out.println("Perímetro del triángulo: " + triangulo.calcularPerimetro());
        System.out.println("Perímetro del rectángulo: " + rectangulo.calcularPerimetro());
        System.out.println("Perímetro del pentágono: " + pentagono.calcularPerimetro());

        System.out.println("2^5 = " + Potencia.calcular(2, 5));
    }
}



