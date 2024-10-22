package com.dsjpooe.javaoo;

import java.util.Locale;
import java.util.Scanner;

public class DesafioBarOOJava {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        char gender;
        int beer;
        int barbecue;
        int softDrink;
        double cover;
        double feeding;
        double ticket = 0.00;
        double bill;

        System.out.println("\nCALCULADORA DE CONTA");

        do {
            System.out.print("\nDigite o sexo do cliente: ");
            gender = scanner.nextLine().toUpperCase().charAt(0);
            if (gender == 'M' || gender == 'F') {
                ticket = ticketPriceByGender(gender);
            } else {
                System.out.println("Valor inválido, digite novamente.");
            }
        }
        while (gender != 'M' & gender != 'F');

        System.out.print("Digite a quantidade de cervejas consumidas: ");
        beer = Math.abs(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Digite a quantidade de refrigerantes consumidos: ");
        softDrink = Math.abs(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Digite a quantidade de espetinhos consumidos: ");
        barbecue = Math.abs(scanner.nextInt());
        scanner.nextLine();

        feeding = feedingCalculator(beer, softDrink, barbecue);
        cover = checkForCouvert(feeding);
        bill = totalBill(ticket, feeding, cover);

        System.out.println("\nRELATÓRIO");
        System.out.println("\nSexo: " + gender);
        System.out.println("Quantidade de cervejas: " + beer);
        System.out.println("Quantidade de refrigerantes: " + softDrink);
        System.out.println("Quantidade de espetinhos: " + barbecue);
        System.out.println("\nConsumo = R$ " + String.format("%.2f", feeding));
        if (cover == 0) {
            System.out.println("Isento de Couvert");
        } else {
            System.out.println("Couvert = R$ " + String.format("%.2f", cover));
        }
        System.out.println("Ingresso = R$ " + String.format("%.2f", ticket));
        System.out.println("\nValor a pagar = R$ " + String.format("%.2f", bill));

        scanner.close();

    }

    public static double ticketPriceByGender(char gender) {
        if (gender == 'M' || gender =='m') {
            return 10.00;
        } else {
            return 8.00;
        }
    }

    public static double feedingCalculator (int beer, int softDrink, int barbecue) {
        return ((double)beer * 5.00) + ((double)softDrink * 3.00) + ((double)barbecue * 7.00);
    }

    public static double checkForCouvert(double feedingTotal) {
       double cover = 0.00;
       if (feedingTotal > 30.00) {
           return cover;
       } else {
           return 4.00;
       }
    }

    public static double totalBill (double ticketPrice, double feedingTotal, double coverPrice) {
        return ticketPrice + feedingTotal + coverPrice;
    }

}
