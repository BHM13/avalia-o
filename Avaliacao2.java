import java.util.Scanner;
  public class Avaliacao2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=== Conversor de Temperatura ==="); 
        System.out.print("Digite a temperatura em Celsius (°C): ");
        double celsius = entrada.nextDouble();
        double fahrenheit = (celsius * 9 / 5) + 32;
        double kelvin = celsius + 273.15;
        System.out.println("\n=== Resultados ===");
        System.out.printf("Temperatura em Celsius: %.2f °C%n", celsius);
        System.out.printf("Temperatura em Fahrenheit: %.2f °F%n", fahrenheit);
        System.out.printf("Temperatura em Kelvin: %.2f K%n", kelvin);
        entrada.close();
    }
}
