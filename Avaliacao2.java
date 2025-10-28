import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Avaliacao2 {
    public static final String RESET = "\u001B[0m";
    public static final String AZUL = "\u001B[34m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";
    public static final String VERMELHO = "\u001B[31m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        List<String> historico = new ArrayList<>();
        String nomeArquivo = "historico.txt";

        File arquivo = new File(nomeArquivo);
        if (arquivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    historico.add(linha);
                }
                System.out.println("Histórico carregado: " + historico.size() + " registros encontrados.");
            } catch (IOException e) {
                System.out.println("Erro ao carregar histórico: " + e.getMessage());
            }
        } else {
            System.out.println("Nenhum histórico anterior encontrado. Criando novo histórico.");
        }

        System.out.println("=== Conversor de Temperaturas ===");

        while (continuar) {
            System.out.println("\nEscolha a escala da temperatura que você vai digitar:");
            System.out.println("1 - Celsius (°C)");
            System.out.println("2 - Fahrenheit (°F)");
            System.out.println("3 - Kelvin (K)");
            System.out.print("Digite o número correspondente à escala: ");
            int escolha = scanner.nextInt();

            double tempInput, celsius = 0, fahrenheit = 0, kelvin = 0;

            System.out.print("Digite a temperatura: ");
            tempInput = scanner.nextDouble();

            switch (escolha) {
                case 1:
                    celsius = tempInput;
                    fahrenheit = (celsius * 9/5) + 32;
                    kelvin = celsius + 273.15;
                    break;
                case 2:
                    fahrenheit = tempInput;
                    celsius = (fahrenheit - 32) * 5/9;
                    kelvin = celsius + 273.15;
                    break;
                case 3:
                    kelvin = tempInput;
                    celsius = kelvin - 273.15;
                    fahrenheit = (celsius * 9/5) + 32;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    continue;
            }

            String classificacao;
            String cor;
            if (celsius < 0) {
                cor = AZUL;
                classificacao = "Frio";
            } else if (celsius <= 25) {
                cor = VERDE;
                classificacao = "Agradável";
            } else if (celsius <= 35) {
                cor = AMARELO;
                classificacao = "Quente";
            } else {
                cor = VERMELHO;
                classificacao = "Muito quente";
            }

            System.out.println("\n=== RESULTADOS DA CONVERSÃO ===");
            System.out.println(cor + "Celsius: " + String.format("%.2f", celsius) + " °C" + RESET);
            System.out.println(cor + "Fahrenheit: " + String.format("%.2f", fahrenheit) + " °F" + RESET);
            System.out.println(cor + "Kelvin: " + String.format("%.2f", kelvin) + " K" + RESET);
            System.out.println("Classificação da temperatura: " + classificacao);

            String registro = String.format("Entrada: %.2f | Celsius: %.2f °C | Fahrenheit: %.2f °F | Kelvin: %.2f K | Classificação: %s",
                    tempInput, celsius, fahrenheit, kelvin, classificacao);
            historico.add(registro);

            System.out.print("\nDeseja converter outra temperatura? (s/n): ");
            String resposta = scanner.next();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (String registro : historico) {
                bw.write(registro);
                bw.newLine();
            }
            System.out.println("\nHistórico salvo com sucesso em '" + nomeArquivo + "'.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar histórico: " + e.getMessage());
        }

        System.out.println("\n=== HISTÓRICO DE CONVERSÕES ===");
        for (String registro : historico) {
            System.out.println(registro);
        }

        System.out.println("\nPrograma encerrado. Obrigado por usar o conversor!");
        scanner.close();
    }
}
