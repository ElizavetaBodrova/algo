package KnuthMorisPratt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter str: ");
        String str = scanner.nextLine();

        System.out.print("Enter pattern: ");
        String pattern = scanner.nextLine();

        KnuthMorrisPratt knuthMorrisPratt=new KnuthMorrisPratt();
        System.out.println("Positions: ");
        knuthMorrisPratt.findKnuthMorrisPratt(str,pattern);
        System.out.println("Compares count: " + KnuthMorrisPratt.getCompares());
    }
}
