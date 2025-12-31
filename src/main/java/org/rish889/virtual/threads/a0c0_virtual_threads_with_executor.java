package org.rish889.virtual.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class a0c0_virtual_threads_with_executor {
    static void main() throws Exception {
        createAVirtualThreadsWithExecutor();
        createManyVirtualThreadsWithExecutor();
    }

    private static void createAVirtualThreadsWithExecutor() throws InterruptedException, ExecutionException {
        try (ExecutorService exec = Executors.newVirtualThreadPerTaskExecutor()) {

            Future<String> f = exec.submit(() -> {
                Thread.sleep(200);
                return "Task done on " + Thread.currentThread();
            });

            System.out.println(f.get());
        }
    }

    private static void createManyVirtualThreadsWithExecutor() {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            futureList.add(executor.submit(() -> {
                Thread.sleep(1000);
                return "Task done on " + Thread.currentThread();
            }));
        }
        futureList.stream()
                .forEach(future -> {
                    try {
                        System.out.println(future.get());
                    } catch (Exception e) {
                        System.out.println("Future failed");
                    }
                });
        executor.shutdown();
    }
}
