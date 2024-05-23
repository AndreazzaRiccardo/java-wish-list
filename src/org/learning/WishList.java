package org.learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WishList {
    public static void main(String[] args) {

        File wishCsv = new File("./resources/wishlist.csv");

        List<String> wishList = new ArrayList<>();

        if(wishCsv.exists() && wishCsv.length() > 0){
            try(Scanner scann = new Scanner(wishCsv)){
                while (scann.hasNextLine()) {
                    wishList.add(scann.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }

        Scanner scann = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.print("Write the name of the gift or type \"e\" to exit ");
            String input = scann.nextLine();

            if("e".equals(input)){
                run = false;
            } else {
                wishList.add(input);
                System.out.println("Your wishlist contains " + wishList.size() + " gifts");
            }
        }

        if(!wishList.isEmpty()){
            Collections.sort(wishList);
            System.out.println(wishList);

            try(FileWriter writer = new FileWriter(wishCsv)){
                for (String gift : wishList) {
                    writer.write(gift + "\n");
                }
            } catch (IOException e) {
                System.out.println("Error writing to file");
            }
        } else {
            System.out.println("Your wishlist is empty");
        }

        scann.close();
    }
}
