    public class Main {
        public static void main(String[] args) {
            // Создание объектов комплексных чисел
            ComplexNumber num1 = new ComplexNumber(2.0, 3.0);
            ComplexNumber num2 = new ComplexNumber(1.0, 2.0);

            // Выполнение операций
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