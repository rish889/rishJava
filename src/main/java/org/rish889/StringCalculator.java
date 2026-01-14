package org.rish889;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String[] tokens = numbers.split("[,\\n]");
        int sum = 0;

        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                sum += Integer.parseInt(token.trim());
            }
        }

        return sum;
    }
}
