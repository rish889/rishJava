package org.rish889;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static void main() {
        List<String> words = List.of(
                "java", "stream", "java", "collector",
                "lambda", "stream", "java", "parallel"
        );

        Map<String, Long> wordFrequencyMap = words.stream()
                .collect(Collectors.groupingBy(w -> w, LinkedHashMap::new, Collectors.counting()));
        System.out.println(wordFrequencyMap);

    }
}