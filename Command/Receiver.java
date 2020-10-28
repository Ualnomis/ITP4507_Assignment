package Command;

import java.util.ArrayList;
import java.util.Scanner;

import Factory.*;
import LunchSet.LunchSet;

public class Receiver {
    private String input;
    private String mainDish;
    private double price;
    private int availableCount;
    private LunchSet lunchSet;
    Scanner sc = new Scanner(System.in);

    public void editMenu(ArrayList<LunchSet> lunchSets) {
        System.out.println();
        System.out.println("Edit Menu:");
        System.out.print("Chinese or Western (c | w):");
        input = sc.nextLine();
        if ("c".equals(input)) {
            lunchSet = lunchSets.get(0);
        } else if ("w".equals(input)) {
            lunchSet = lunchSets.get(1);
        }
        System.out.print("Enter main dish: ");
        mainDish = sc.nextLine();
        lunchSet.setMainDish(mainDish);
        System.out.print("Enter price: ");
        price = sc.nextDouble();
        lunchSet.setPrice(price);
        System.out.print("Enter available count:");
        availableCount = sc.nextInt();
        lunchSet.setAvailableCount(availableCount);
        System.out.println("Menu Updated");
        System.out.println();
    }

    public void showMenu(ArrayList<LunchSet> lunchSets) {
        for (int i = 0; i < lunchSets.size(); i++) {
            System.out.println();
            System.out.println(lunchSets.get(0));
            System.out.println();
            System.out.println(lunchSets.get(1));
            System.out.println();
        }
    }
}
