package com.example.vault.services;

import com.example.vault.entities.ItemLoad;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class FileService {

    List<ItemLoad> itemLoadList = new ArrayList<>();
    List<String> customers = new ArrayList<>();

    @PostConstruct
    void readTxtFile() {
        File file = new File("input.txt");
        double total = 0d;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println("data read from file::::   " + data);
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
//            int exist = itemLoadList.indexOf("528") + 1;
//            System.out.println("Index:::  " + exist);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void writeTxtFile() {
        //to be done
    }

    double maximumAmountPerDay() {
        return 0d;
    }

//    double getSpendPerDay(String date) {
//        re
//    }

}
