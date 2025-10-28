import java.util.Scanner;

public class Avaliacao1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double[] notas = new double[8];

        final String RESET = "\u001B[0m";
        final String VERDE = "\u001B[32m";
        final String AMARELO = "\u001B[33m";
        final String VERMELHO = "\u001B[31m";
        final String AZUL = "\u001B[36m";

        System.out.println(AZUL + "=====================================");
        System.out.println("   SISTEMA ESCOLAR - AVALIAÇÃO 2   ");
        System.out.println("=====================================" + RESET);

        System.out.print("\nDigite o nome do aluno: ");
        String nome = entrada.nextLine();

        System.out.println("\nDigite as 8 notas anuais (de 0 a 10):");
        for (int i = 0; i < 8; i++) {
            do {
                System.out.print("Nota " + (i + 1) + ": ");
                notas[i] = entrada.nextDouble();

                if (notas[i] < 0 || notas[i] > 10) {
                    System.out.println(VERMELHO + "Valor inválido! Digite uma nota entre 0 e 10." + RESET);
                }
            } while (notas[i] < 0 || notas[i] > 10);
        }

        double b1 = (notas[0] + notas[1]) / 2;
        double b2 = (notas[2] + notas[3]) / 2;
        double b3 = (notas[4] + notas[5]) / 2;
        double b4 = (notas[6] + notas[7]) / 2;

        double s1 = (b1 + b2) / 2;
        double s2 = (b3 + b4) / 2;
        double mediaFinal = (s1 + s2) / 2;

        String situacao;
        String mensagem;

        if (mediaFinal >= 7) {
            situacao = VERDE + "Aprovado" + RESET;
            mensagem = "Excelente desempenho! Continue assim, " + nome + "!";
        } else if (mediaFinal >= 5) {
            situacao = AMARELO + "Recuperação" + RESET;
            mensagem = "Você está quase lá, " + nome + ". Revise os conteúdos e se esforce um pouco mais.";
        } else {
            situacao = VERMELHO + "Reprovado" + RESET;
            mensagem = "Não desista, " + nome + ". Procure ajuda e estude mais para melhorar.";
        }

        System.out.println(AZUL + "\n=====================================");
        System.out.println("         RELATÓRIO ESCOLAR           ");
        System.out.println("=====================================" + RESET);
        System.out.println("Aluno: " + nome);
        System.out.println("-------------------------------------");
        System.out.printf("1º Bimestre: %.1f%n", b1);
        System.out.printf("2º Bimestre: %.1f%n", b2);
        System.out.printf("1º Semestre: %.1f%n", s1);
        System.out.println("-------------------------------------");
        System.out.printf("3º Bimestre: %.1f%n", b3);
        System.out.printf("4º Bimestre: %.1f%n", b4);
        System.out.printf("2º Semestre: %.1f%n", s2);
        System.out.println("-------------------------------------");
        System.out.printf("Média Final: %.1f%n", mediaFinal);
        System.out.println("Situação: " + situacao);
        System.out.println("-------------------------------------");
        System.out.println(mensagem);
        System.out.println("=====================================");
        System.out.println("Cálculo concluído com sucesso!");
        System.out.println("=====================================");

        entrada.close();
    }
}
