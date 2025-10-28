import java.util.Scanner;

public class Avaliacao2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        char continuar;
        int contador = 0;

        // Cores ANSI
        final String RESET = "\u001B[0m";
        final String VERMELHO = "\u001B[31m";
        final String VERDE = "\u001B[32m";
        final String AMARELO = "\u001B[33m";
        final String AZUL = "\u001B[36m";
        final String NEGRITO = "\u001B[1m";

        System.out.println(AZUL + "=====================================");
        System.out.println("       CONVERSOR DE TEMPERATURAS     ");
        System.out.println("=====================================" + RESET);
        System.out.println("Este programa converte °C em °F e K, classifica o clima e mostra informações adicionais.\n");

        do {
            contador++;

            System.out.print(NEGRITO + "Digite a temperatura em Celsius (°C): " + RESET);
            double celsius = entrada.nextDouble();

            double fahrenheit = (celsius * 9 / 5) + 32;
            double kelvin = celsius + 273.15;
            double diferenca = Math.abs(fahrenheit - celsius);

            String classificacao;
            String corClassificacao;

            if (celsius < 0) {
                classificacao = "Muito fria";
                corClassificacao = AZUL;
            } else if (celsius < 15) {
                classificacao = "Fria";
                corClassificacao = AZUL;
            } else if (celsius < 25) {
                classificacao = "Agradável";
                corClassificacao = VERDE;
            } else if (celsius < 35) {
                classificacao = "Quente";
                corClassificacao = AMARELO;
            } else {
                classificacao = "Extremamente quente";
                corClassificacao = VERMELHO;
            }

            System.out.println(AZUL + "\n----------- RESULTADOS -----------" + RESET);
            System.out.printf("Temperatura em Celsius: %.2f °C%n", celsius);
            System.out.printf("Temperatura em Fahrenheit: %.2f °F%n", fahrenheit);
            System.out.printf("Temperatura em Kelvin: %.2f K%n", kelvin);
            System.out.printf("Diferença entre °C e °F: %.2f%n", diferenca);
            System.out.println("Classificação: " + corClassificacao + classificacao + RESET);

            if (celsius < 0) {
                System.out.println(VERMELHO + "Alerta: risco de congelamento!" + RESET);
            } else if (celsius > 40) {
                System.out.println(VERMELHO + "Alerta: risco de superaquecimento!" + RESET);
            }

            System.out.println(AZUL + "----------------------------------" + RESET);

            System.out.print("\nDeseja converter outra temperatura? (S/N): ");
            continuar = entrada.next().toUpperCase().charAt(0);
            System.out.println();

        } while (continuar == 'S');


        System.out.println(AZUL + "=====================================" + RESET);
        System.out.println(NEGRITO + " Programa finalizado com sucesso! " + RESET);
        System.out.println(" Total de conversões realizadas: " + contador);

        if (contador == 1) {
            System.out.println("Você fez apenas uma conversão. Volte sempre!");
        } else if (contador <= 3) {
            System.out.println("Bom trabalho! Você fez várias conversões.");
        } else {
            System.out.println("Excelente! Você utilizou bem o sistema.");
        }

        System.out.println(AZUL + "=====================================" + RESET);
        entrada.close();
    }
}
