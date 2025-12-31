package org.rish889.virtual.threads;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a0f0_virtual_threads_with_completable_future {
    static void main() {

        try (ExecutorService exec = Executors.newVirtualThreadPerTaskExecutor()) {
            CompletableFuture.runAsync(() -> {
                System.out.println("Hello from virtual thread! " + Thread.currentThread());
            }, exec);
        }
    }
}
