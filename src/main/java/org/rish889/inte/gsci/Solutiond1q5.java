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

    public String fractionToDecimal(int num, int den) {
        if (num == 0) return "0";

        StringBuilder result = new StringBuilder();

        result.append(num / den);
        long rem = num % den;

        if (rem == 0) {
            return result.toString();
        }

        result.append(".");
        Map<Long, Integer> remToIndexMap = new HashMap<>();

        while (rem != 0) {
            if (remToIndexMap.containsKey(rem)) {
                int index = remToIndexMap.get(rem);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            remToIndexMap.put(rem, result.length());

            rem *= 10;
            result.append(rem / den);
            rem %= den;
        }

        return result.toString();
    }
}

