package org.rish889.virtual.threads;

import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class a0d0_io_task {
    static void main() throws Exception {
        try (ExecutorService exec = Executors.newVirtualThreadPerTaskExecutor()) {

            Future<String> res = exec.submit(() -> fetch("https://example.com"));

            System.out.println(res.get());
        }
    }

    static String fetch(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        try (BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return r.readLine();
        }
    }
}
