package org.rish889.inte.gsci;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solutiond1q3 {
    public static void main(String[] args) {
        Solutiond1q3 sol = new Solutiond1q3();
        sol.addFractions(new int[]{2, 3}, new int[]{1, 2});
        sol.addFractions(new int[]{3, 2}, new int[]{1, 4});
    }

    public int[] addFractions(int[] fraction1, int[] fraction2) {
        int num1 = fraction1[0];
        int den1 = fraction1[1];
        int num2 = fraction2[0];
        int den2 = fraction2[1];

        int numerator = num1 * den2 + num2 * den1;
        int denominator = den1 * den2;

        int gcd = gcd(numerator, denominator);

        numerator = numerator / gcd;
        denominator = denominator / gcd;

        System.out.println(numerator + "/" + denominator);

        return new int[]{numerator, denominator};
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

