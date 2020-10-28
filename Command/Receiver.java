package Command;

import java.util.ArrayList;
import java.util.Scanner;

import Factory.*;
import LunchSet.LunchSet;
import Order.Order;

public class Receiver {
    private String input;
    private LunchSet lunchSet;
    Scanner sc = new Scanner(System.in);

    public void editMenu(ArrayList<LunchSet> lunchSets) {
        System.out.println();
        System.out.println("Edit Menu:");
        System.out.print("Chinese or Western (c | w):");
        String input = sc.nextLine();
        if ("c".equals(input)) {
            lunchSet = lunchSets.get(0);
        } else if ("w".equals(input)) {
            lunchSet = lunchSets.get(1);
        }
        System.out.print("Enter main dish: ");
        String mainDish = sc.nextLine();
        lunchSet.setMainDish(mainDish);
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        lunchSet.setPrice(price);
        System.out.print("Enter available count:");
        int availableCount = sc.nextInt();
        sc.nextLine();
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

    public void makeOrder(ArrayList<LunchSet> lunchSets, ArrayList<Order> orders) {
        System.out.println();
        System.out.println("Place Order");
        System.out.print("Chinese or Western (c | w):");
        input = sc.nextLine();
        String teaType = "";
        String side = "";
        if ("c".equals(input)) {
            lunchSet = lunchSets.get(0);
            if (lunchSet.getAvailableCount() > 0) {
                System.out.print("Oolong Tea: hot or iced (h | i): ");
                teaType = sc.nextLine();
                if ("h".equals(teaType)) {
                    teaType = "Hot Tea";
                } else if ("i".equals(teaType)) {
                    teaType = "Iced Tea";
                }
                input = "C";
            } else {
                System.out.println("Sold Out!");
                return;
            }
        } else if ("w".equals(input)) {
            lunchSet = lunchSets.get(1);
            if (lunchSet.getAvailableCount() > 0) {
                System.out.print("side: rice, spaghetti, French fries (r | s | f): ");
                side = sc.nextLine();
                if ("r".equals(side)) {
                    side = "rice";
                } else if ("s".equals(side)) {
                    side = "spaghetti";
                } else if ("f".equals(side)) {
                    side = "French fries";
                }

                System.out.print("Oolong Tea: hot or iced (h | i): ");
                teaType = sc.nextLine();
                if ("h".equals(teaType)) {
                    teaType = "Hot Tea";
                } else if ("i".equals(teaType)) {
                    teaType = "Iced Tea";
                }
                input = "W";
            } else {
                System.out.println("Sold Out!");
                return;
            }
        } else {
            System.out.println("Invalid Option!");
            return;
        }
        System.out.print("Staff Number:");
        int staffNum = sc.nextInt();
        System.out.print("Office Location:");
        int officeLocation = sc.nextInt();
        Order order = new Order(staffNum, officeLocation, lunchSet, input, side, teaType);
        orders.add(order);
        lunchSet.setAvailableCount(lunchSet.getAvailableCount() - 1);
        System.out.println();
    }
}
