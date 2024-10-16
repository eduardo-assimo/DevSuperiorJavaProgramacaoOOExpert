package desafio.impostojava;

import java.util.Locale;
import java.util.Scanner;

public class DesafioValorDoImposto {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de cálculo de imposto!\n");
        System.out.print("Digite seu salário, em reais: ");

        double sal = sc.nextDouble();
        double imp = 0;

        if (sal < 0.0) {
            System.out.println("\nValor Inválido: valor mínimo é de R$ 0.00");
        }
        else if (sal <= 2000.0) {
            System.out.println("\nISENTO");
        }
        else {
            if (sal <= 3000.0) {
                imp = (sal - 2000.0) * 0.08;
            } else if (sal <= 4500.0) {
                imp = (sal - 3000.0) * 0.18 + 1000.0 * 0.08;
            }
            else {
                imp = (sal - 4500.0) * 0.28 + 1500.0 * 0.18 + 1000.0 * 0.08;
            }
            System.out.printf("\nO imposto devido é no valor de R$ %.2f%n", imp);
        }

        sc.close();
    }
}