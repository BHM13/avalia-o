import java.util.Scanner;
    public class SistemaEscolar {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double[] notas = new double[8];

        System.out.println("=== Sistema Escolar - Cálculo de Médias ===");

        for (int i = 0; i < 8; i++) {
            System.out.print("Digite a nota " + (i + 1) + ": ");
            notas[i] = entrada.nextDouble();
        }

        double b1 = (notas[0] + notas[1]) / 2;
        double b2 = (notas[2] + notas[3]) / 2;
        double b3 = (notas[4] + notas[5]) / 2;
        double b4 = (notas[6] + notas[7]) / 2;

        double s1 = (b1 + b2) / 2;
        double s2 = (b3 + b4) / 2;

        double mediaFinal = (s1 + s2) / 2;

        System.out.println("\n=== Resultado ===");
        System.out.printf("1º Bimestre: %.1f%n", b1);
        System.out.printf("2º Bimestre: %.1f%n", b2);
        System.out.printf("1º Semestre: %.1f%n", s1);
        System.out.println("--------------------------");
        System.out.printf("3º Bimestre: %.1f%n", b3);
        System.out.printf("4º Bimestre: %.1f%n", b4);
        System.out.printf("2º Semestre: %.1f%n", s2);
        System.out.println("--------------------------");
        System.out.printf("Média Final: %.1f%n", mediaFinal);

        entrada.close();
    }
}
