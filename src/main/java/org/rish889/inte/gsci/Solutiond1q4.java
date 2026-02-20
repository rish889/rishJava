package org.rish889.inte.gsci;

import java.util.ArrayList;
import java.util.List;

public class Solutiond1q4 {
    public static void main(String[] args) {
        Solutiond1q4 sol = new Solutiond1q4();
        System.out.println(sol.getPrimeFactors(6));
        System.out.println(sol.getPrimeFactors(5));
        System.out.println(sol.getPrimeFactors(30));
    }

    public List<Integer> getPrimeFactors(int x) {
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i * i <= x; i += 1) {
            while (x % i == 0) {
                result.add(i);
                x /= i;
            }
        }

        result.add(x);

        return result;
    }
}

