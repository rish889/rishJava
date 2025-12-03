package org.rish889.virtual.threads;


import java.util.*;
import java.util.concurrent.*;

public class a0e0_parallel_task_fan_in_fan_out {
    static void main() throws Exception {

        List<String> urls = List.of(
                "https://example.com",
                "https://openai.com",
                "https://github.com"
        );

        try (ExecutorService exec = Executors.newVirtualThreadPerTaskExecutor()) {

            List<Future<String>> futures = urls.stream()
                    .map(url -> exec.submit(() -> fetch(url)))
                    .toList();

            List<String> results = new ArrayList<>();

            for (Future<String> f : futures) {
                results.add(f.get());
            }

            results.forEach(System.out::println);
        }
    }

    static String fetch(String url) throws Exception {
        Thread.sleep(200);
        return "Fetched: " + url + " on " + Thread.currentThread();
    }
}
