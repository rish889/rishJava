package org.rish889;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        List<String> rawList = new ArrayList<>();

        List list = new ArrayList();  // raw type
        List<String> strList = list;  // ⚠ unchecked assignment

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}