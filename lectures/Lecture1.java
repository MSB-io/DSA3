package lectures;

import java.util.ArrayList;

// Class Creation and 
public class Lecture1 {
    public static void main(String[] args) {
        // String name="Rizwan";
        // name=name.concat(" Python Developer");
        // System.out.println(name);

        // ArrayList
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(20); // duplicate
        list.add(40); // duplicate

        // System.out.println("Element if Array" + list);
        // System.out.println("Index bases" + list.get(0));
        // list.remove(02);
        // list.set(1, 6);

        // for (int number : list) {
        // System.out.println("Iteration" + number);

        // }

        // ArrayList<Integer> num = new ArrayList<Integer>();
        // for (int i = 0; i < 100; i += 10) {
        // num.add(i);
        // }
        // System.out.println(num);

        // int sum = 0;
        // for (int i : num) {
        // sum += i;
        // }
        // System.out.println(sum);

        // // Keep an element only if it is not already in the new ArrayList.
        // ArrayList<Integer> noDup = new ArrayList<Integer>();
        // for (int value : list) {
        // if (!noDup.contains(value)) {
        // noDup.add(value);
        // }
        // }

        // // Add a new element only if it does not already exist.
        // if (!noDup.contains(60)) {
        // noDup.add(60);
        // }

        // System.out.println("Without duplicates: " + noDup);

        // int largest = list.get(0);
        // for (int i = 1; i < list.size(); i++) {
        // if (list.get(i) > largest) {
        // largest = list.get(i);
        // }
        // }

        // System.out.println("This is the Largest Element: " + largest);

        // Problem Statement 1:
        // 1) add products in add to cart
        // 2) display all products
        // 3) remove product from cart
        // 4) display prize of all the availale products

        class Product {
            String name;
            int price;

            Product(String name, int price) {
                this.name = name;
                this.price = price;
            }
        }

        ArrayList<Product> cart = new ArrayList<>();

        cart.add(new Product("Laptop", 50000));
        cart.add(new Product("Mouse", 500));
        cart.add(new Product("Keyboard", 1500));

        System.out.println("Shopping Cart:");

        for (Product p : cart) {
            System.out.println(p.name + " - Rs." + p.price);
        }

        cart.removeIf(p -> p.name.equals("Mouse"));

        System.out.println("\nAfter Removing Mouse:");

        for (Product p : cart) {
            System.out.println(p.name + " - Rs." + p.price);
        }

        int total = 0;

        for (Product p : cart) {
            total = total + p.price;
        }

        System.out.println("\nTotal Bill: Rs." + total);
    }
}