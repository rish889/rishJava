package org.rish889.virtual.threads;

import java.util.concurrent.*;

public class a0c0_virtual_threads_with_executor {
    static void main() throws Exception {
        try (ExecutorService exec = Executors.newVirtualThreadPerTaskExecutor()) {

            Future<String> f = exec.submit(() -> {
                Thread.sleep(200);
                return "Task done on " + Thread.currentThread();
            });

            System.out.println(f.get());
        }
    }
}
