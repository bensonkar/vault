package com.example.vault.services;

import com.example.vault.entities.ItemLoad;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

@Service
public class FileService {

    List<ItemLoad> itemLoadList = new ArrayList<>();
    List<String> customers = new ArrayList<>();

    //    @PostConstruct
    public void readTxtFile(String name) {
        File file = new File(name);
        double total = 0d;
        StringBuffer buffer = new StringBuffer();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println("data read from file::::   " + data);
                writeTxtFile(data + System.lineSeparator());
                ItemLoad load = new Gson().fromJson(data, ItemLoad.class);
                customers.add(load.getCustomer_id());
                itemLoadList.add(load);
//                itemLoadList.stream().forEach(k -> {
//
//                });
//                System.out.println("new updated data:::   " + load);
//                total += Double.parseDouble(load.getLoad_amount().replace("$", ""));
//                for (String c : customers) {
//                    if (c.equals(load.getCustomer_id())) {
////                        double b = 0;
//                        total += Double.parseDouble(load.getLoad_amount().replace("$", ""));
//                        System.out.println("new updated data:::   " + load);
////                        if (total > 10000) {
////                            System.out.println("total per day exceeded");
////                            break;
////                        }
//                    }
//                }
            }
            scanner.close();
//            System.out.println("Total:  " + total);
            System.out.println("data:::  " + itemLoadList);
            System.out.println("Duplicates:::   " + getDuplicates(itemLoadList));
//            int exist = itemLoadList.indexOf("528") + 1;
//            System.out.println("Index:::  " + exist);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void writeTxtFile(String message) {
        //call create file
        createFile("output.txt");
        try {
            FileWriter writer = new FileWriter("output.txt", true);
            writer.write(message);
            writer.close();
            System.out.println("file written successfully with message::  " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void createFile(String name) {
        File file = new File(name);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    double maximumAmountPerDay() {
        return 0d;
    }

//    double getSpendPerDay(String date) {
//        re
//    }

    List<ItemLoad> getDuplicates(List<ItemLoad> loads) {
        List<ItemLoad> duplicates = new ArrayList<>();
        for (int i = 0; i < loads.size(); i++) {
            if (loads.indexOf(i) + 1 == loads.indexOf(i + 1) + 1) {
                ItemLoad load = loads.get(loads.indexOf(i) + 1);
                duplicates.add(load);
            }
        }
        return duplicates;
    }


}
