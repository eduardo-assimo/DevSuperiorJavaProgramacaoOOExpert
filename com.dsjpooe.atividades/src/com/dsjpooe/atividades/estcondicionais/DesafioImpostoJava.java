package com.dsjpooe.atividades.estcondicionais;

import java.util.Locale;
import java.util.Scanner;


public class DesafioImpostoJava {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de cálculo de imposto!\n");
        System.out.print("Digite seu salário anual, em reais: ");

        double sal = sc.nextDouble();
        double impSal = calculaImpostoSalarioAnual(sal);

        System.out.print("Digite sua renda com Prestação de Serviços anual, em reais: ");

        double rendaPrestServ = sc.nextDouble();
        double impPrestServ = calculaImpostoSobrePrestacaoDeServicosAnual(rendaPrestServ);

        System.out.print("Digite sua renda com Ganho de Capitais anual, em reais: ");

        double ganhoDeCapital = sc.nextDouble();
        double impGanhoDeCapital = calculaImpostoSobreGanhoDeCapitaisAnual(ganhoDeCapital);

        double impBruto = impSal + impPrestServ + impGanhoDeCapital;

        System.out.print("Digite seu Gasto Médido anual, em reais: ");

        double gastosMedicos = sc.nextDouble();

        System.out.print("Digite seu Gasto Educacional anual, em reais: ");

        double gastosEducacionais = sc.nextDouble();

        double gastoBruto = gastosMedicos + gastosEducacionais;
        double maxDedutivel = impBruto * 0.30;
        double abatimento = calculaGastosDedutiveis(impBruto, gastoBruto);
        double impDevido = impBruto - abatimento;

        System.out.printf("\nRenda anual com salário: R$ %.2f%n", sal);
        System.out.printf("Renda anual com prestação de serviço: R$ %.2f%n", rendaPrestServ);
        System.out.printf("Renda anual com ganho de capital: R$ %.2f%n", ganhoDeCapital);
        System.out.printf("Gastos médicos: R$ %.2f%n", gastosMedicos);
        System.out.printf("Gastos educacionais: R$ %.2f%n", gastosEducacionais);
        System.out.println("\nRELATÓRIO DE IMPOSTO DE RENDA");
        System.out.println("\nCONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: R$ %.2f%n", impSal);
        System.out.printf("Imposto sobre serviço: R$ %.2f%n", impPrestServ);
        System.out.printf("Imposto sobre ganho de capital: R$ %.2f%n", impGanhoDeCapital);
        System.out.println("\nDEDUÇÕES:");
        System.out.printf("Máximo dedutível: R$ %.2f%n", maxDedutivel);
        System.out.printf("Gastos dedutíveis: R$ %.2f%n", gastoBruto);
        System.out.println("\nRESUMO:");
        System.out.printf("Imposto bruto total: R$ %.2f%n", impBruto);
        System.out.printf("Abatimento: R$ %.2f%n", abatimento);
        System.out.printf("Imposto devido: R$ %.2f%n", impDevido);

        sc.close();
    }

    public static double calculaImpostoSalarioAnual (double salarioAnual) {

        double salarioMensal = Math.abs(salarioAnual) / 12.00;
        double imp;

        if (salarioMensal <= 3000.00) {
            imp = 0.00;
        }
        else if (salarioMensal <= 5000.00) {
            imp = salarioAnual * 0.10;
        }
        else {
            imp = salarioAnual * 0.20;
        }

        return imp;
    }

    public static double calculaImpostoSobrePrestacaoDeServicosAnual (double rendaAnualPrestServ) {
        return Math.abs(rendaAnualPrestServ) * 0.15;
    }

    public static double calculaImpostoSobreGanhoDeCapitaisAnual (double ganhoAnualCapitais) {
        return Math.abs(ganhoAnualCapitais) * 0.20;
    }

    public static double calculaGastosDedutiveis (double impBruto, double gastoBruto) {
        double maxDedutivel = impBruto * 0.30;
        return Math.min(gastoBruto, maxDedutivel);
    }
}
