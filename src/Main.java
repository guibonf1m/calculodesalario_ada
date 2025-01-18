import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double[] salarios = new double[5];

        for (int i = 0; i < salarios.length; i++) {
            System.out.print("Digite o salário bruto do funcionário " + (i + 1) + ": ");
            salarios[i] = scanner.nextDouble();
        }

        int contagem = 1;
        for (double salario : salarios) {
            double inss = calcularINSS(salario);
            double ir = calcularIR(salario - inss);
            double salarioLiquido = salario - inss - ir;

            System.out.printf("Funcionário %d:\n", contagem++);
            System.out.printf("Salário bruto: R$%.2f\n", salario);
            System.out.printf("Total pago ao INSS: R$%.2f\n", inss);
            System.out.printf("Total pago de Imposto de Renda: R$%.2f\n", ir);
            System.out.printf("Salário líquido: R$%.2f\n\n", salarioLiquido);
        }
        scanner.close();
    }

    public static double calcularINSS(double salario) {
        if (salario <= 1212.00) {
            return salario * 0.075;
        } else if (salario <= 2427.35) {
            return salario * 0.09;
        } else if (salario <= 3641.03) {
            return salario * 0.12;
        } else if (salario <= 7087.22) {
            return salario * 0.14;
        } else {
            return 7087.22 * 0.14;
        }
    }

    public static double calcularIR(double salario) {
        if (salario <= 1903.98) {
            return 0;
        } else if (salario <= 2826.65) {
            return salario * 0.075;
        } else if (salario <= 3751.05) {
            return salario * 0.15;
        } else if (salario <= 4664.68) {
            return salario * 0.225;
        } else {
            return salario * 0.275;
        }
    }
}