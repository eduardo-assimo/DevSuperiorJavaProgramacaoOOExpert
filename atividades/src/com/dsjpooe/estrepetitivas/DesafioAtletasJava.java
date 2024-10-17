package com.dsjpooe.estrepetitivas;

import java.util.Locale;
import java.util.Scanner;

public class DesafioAtletasJava {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        int quantAtletas;

        do {
            System.out.print("\nQual a quantidade de atletas? ");
            quantAtletas = Math.abs(scanner.nextInt());
            if (quantAtletas == 0) {
                System.out.println("A quantidade mínima é de 1 atleta.");
            }
        }
        while (quantAtletas == 0);

        String nomeAtleta;
        String sexoAtleta;
        int quantHomens = 0;
        int quantMulheres = 0;
        double porcentagemHomens;
        double alturaAtleta;
        double somaAlturaMulheres = 0;
        double alturaMediaMulheres;
        double alturaMaior = 0;
        String nomeAtletaMaisAlto = "";
        double pesoAtleta;
        double somaPesoAtleta = 0;
        double pesoMedioAtletas;

        for (int i = 1; i <= quantAtletas; i++) {
            System.out.println("\nDigite os dados do atleta número " + i + ":");
            scanner.nextLine();
            System.out.print("Nome: ");
            nomeAtleta = scanner.nextLine().toUpperCase();

            do {
                System.out.print("Sexo: ");
                sexoAtleta = scanner.next().toUpperCase();
                if (!sexoAtleta.equals("F") && !sexoAtleta.equals("M")) {
                    System.out.println("Valor inválido! Favor digitar F ou M. ");
                }
            }
            while (!sexoAtleta.equals("F") && !sexoAtleta.equals("M"));

            do {
                System.out.print("Altura: ");
                alturaAtleta = scanner.nextDouble();
                if (alturaAtleta <= 0) {
                    System.out.println("Valor inválido! Favor digitar um valor positivo.");
                }
            }
            while (alturaAtleta <= 0);

            do {
                System.out.print("Peso: ");
                pesoAtleta = scanner.nextDouble();
                if (pesoAtleta <= 0) {
                    System.out.println("Valor inválido! Favor digitar um valor positivo.");
                }
            }
            while (pesoAtleta <= 0);

            if (sexoAtleta.equals("F")) {
                quantMulheres++;
                somaAlturaMulheres += alturaAtleta;
            } else {
                quantHomens++;
            }

            if (alturaAtleta >= alturaMaior) {
                alturaMaior = alturaAtleta;
                nomeAtletaMaisAlto = nomeAtleta;
            }

            somaPesoAtleta += pesoAtleta;
        }

        pesoMedioAtletas = somaPesoAtleta/quantAtletas;
        porcentagemHomens = ((double) quantHomens/quantAtletas) * 100.0;
        alturaMediaMulheres = quantMulheres > 0 ? somaAlturaMulheres / quantMulheres : 0;

        System.out.println();
        System.out.println("RELATÓRIO:");
        System.out.println("Peso médio dos atletas: "+ String.format("%.2f", pesoMedioAtletas) + " kg");
        System.out.println("Atleta mais alto: " + nomeAtletaMaisAlto);
        System.out.println("Porcentagem de homens: " + String.format("%.2f", porcentagemHomens) + " %");
        if (quantMulheres != 0) {
            System.out.println("Altura média das mulheres: " + String.format("%.2f", alturaMediaMulheres) + " m");
        } else {
            System.out.println("Não há mulheres cadastradas");
        }

        scanner.close();
    }
}
