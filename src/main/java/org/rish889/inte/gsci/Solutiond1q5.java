package org.rish889.inte.gsci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solutiond1q5 {
    public static void main(String[] args) {
        Solutiond1q5 sol = new Solutiond1q5();
        System.out.println(sol.fractionToDecimal(1, 2));
        System.out.println(sol.fractionToDecimal(1, 3));
        System.out.println(sol.fractionToDecimal(4, 7));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        result.append(numerator / denominator);

        long remainder = numerator % denominator;
        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");
        Map<Long, Integer> remainderToIndexMap = new HashMap<>();

        while (remainder != 0) {
            if (remainderToIndexMap.containsKey(remainder)) {
                int index = remainderToIndexMap.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            remainderToIndexMap.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / denominator);
            remainder %= denominator;
        }

        return result.toString();
    }
}

