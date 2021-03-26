package VagnerPhisher;

import java.util.Scanner;

public class MainVagnerPhisher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter str1: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter str2: ");
        String str2 = scanner.nextLine();
        System.out.println(VagnerPhisher.levenstain(str1, str2));
        System.out.println("Compares count: " + VagnerPhisher.counter);
    }
}
