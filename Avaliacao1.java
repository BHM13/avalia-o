import java.util.Scanner;

public class Avaliacao1 {

    public static final String RESET = "\u001B[0m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";
    public static final String VERMELHO = "\u001B[31m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;

        do {
            System.out.print("Digite o nome do aluno: ");
            String nomeAluno = sc.nextLine();

            double[] notas = new double[8];

            System.out.println("\nDigite as 8 notas do aluno (entre 0 e 10):");
            for (int i = 0; i < 8; i++) {
                while (true) {
                    System.out.print((i + 1) + "ª nota: ");
                    double nota = sc.nextDouble();
                    if (nota >= 0 && nota <= 10) {
                        notas[i] = nota;
                        break;
                    } else {
                        System.out.println("Nota inválida! Digite um valor entre 0 e 10.");
                    }
                }
            }
            sc.nextLine(); 

            double[] mediasBimestrais = new double[4];
            for (int i = 0; i < 4; i++) {
                mediasBimestrais[i] = (notas[i * 2] + notas[i * 2 + 1]) / 2;
            }

            double[] mediasSemestrais = new double[2];
            mediasSemestrais[0] = (mediasBimestrais[0] + mediasBimestrais[1]) / 2;
            mediasSemestrais[1] = (mediasBimestrais[2] + mediasBimestrais[3]) / 2;

            double mediaFinal = (mediasSemestrais[0] + mediasSemestrais[1]) / 2;

            System.out.println("\nResultados do Aluno: " + nomeAluno);
            System.out.println("-------------------------------");
            for (int i = 0; i < 4; i++) {
                System.out.println((i * 2 + 1) + "º Bimestre: " + corNota(notas[i * 2]));
                System.out.println((i * 2 + 2) + "º Bimestre: " + corNota(notas[i * 2 + 1]));
                if (i % 2 == 1) {
                    System.out.println((i / 2 + 1) + "º Semestre: " + corNota(mediasSemestrais[i / 2]));
                    System.out.println("----------------------");
                }
            }

            System.out.println("Média Final: " + corNota(mediaFinal));
            System.out.println("Situação: " + situacao(mediaFinal));

            if (mediaFinal < 7) {
                double pontosFaltantes = 7 - mediaFinal;
                System.out.printf("Pontos que faltam para passar: %.2f%n", pontosFaltantes);
            } else {
                System.out.println("Parabéns! O aluno já passou de ano.");
            }

            System.out.println("\nDeseja registrar outro aluno? (sim/nao)");
            continuar = sc.nextLine().trim().toLowerCase();

        } while (continuar.equals("sim"));

        System.out.println("\nPrograma encerrado.");
        sc.close();
    }

    public static String corNota(double nota) {
        if (nota >= 7) return VERDE + nota + RESET;
        else if (nota >= 5) return AMARELO + nota + RESET;
        else return VERMELHO + nota + RESET;
    }
    public static String situacao(double nota) {
        if (nota >= 7) return "Aprovado";
        else if (nota >= 5) return "Recuperação";
        else return "Reprovado";
    }
}
