import java.util.Scanner;

public class ComplexNumber {
    private double real;
    private double imaginary;

    // Конструктор по умолчанию
    public ComplexNumber() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    // Конструктор с параметрами
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Метод сложения
    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    // Метод вычитания
    public ComplexNumber subtract(ComplexNumber other) {
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    // Метод умножения
    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    // Метод деления
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(newReal, newImaginary);
    }

    // Метод для отображения комплексного числа в виде строки
    @Override
    public String toString() {
        return "(" + real + " + " + imaginary + "i)";
    }

    // Пример использования
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите действительную часть первого числа: ");
        double real1 = scanner.nextDouble();
        System.out.print("Введите мнимую часть первого числа: ");
        double imaginary1 = scanner.nextDouble();
        ComplexNumber num1 = new ComplexNumber(real1, imaginary1);


        System.out.print("Введите действительную часть второго числа: ");
        double real2 = scanner.nextDouble();
        System.out.print("Введите мнимую часть второго числа: ");
        double imaginary2 = scanner.nextDouble();
        ComplexNumber num2 = new ComplexNumber(real2, imaginary2);

        ComplexNumber sum = num1.add(num2);
        System.out.println("Сумма: " + sum);

        ComplexNumber difference = num1.subtract(num2);
        System.out.println("Разность: " + difference);

        ComplexNumber product = num1.multiply(num2);
        System.out.println("Произведение: " + product);

        ComplexNumber quotient = num1.divide(num2);
        System.out.println("Частное: " + quotient);
    }
}
