package Command;

import java.util.Scanner;

import Factory.*;

public class Receiver {
    Scanner sc = new Scanner(System.in);
    private String input;
    private double price;
    private int availableCount;

    public void editMenu() {
        System.out.println();
        System.out.println("Edit Menu:");
        System.out.print("Chinese or Western (c | w):");
        input = sc.nextLine();
        System.out.print("Enter main dish:");
        input = sc.nextLine();
        System.out.print("Enter price");
        price = sc.nextDouble();
        System.out.print("Enter available count:");
        availableCount = sc.nextInt();
        System.out.println("Menu Updated");
        System.out.println();
    }
}
