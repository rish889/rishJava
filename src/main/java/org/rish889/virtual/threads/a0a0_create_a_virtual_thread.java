package org.rish889.virtual.threads;

public class a0a0_create_a_virtual_thread {
    static void main() throws Exception {
        Thread vt = Thread.startVirtualThread(() -> {
            System.out.println("Hello from virtual thread! " + Thread.currentThread());
        });

        vt.join(); // wait for it to finish
    }
}
