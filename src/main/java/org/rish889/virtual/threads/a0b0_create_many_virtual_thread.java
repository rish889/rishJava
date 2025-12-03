package org.rish889.virtual.threads;

public class a0b0_create_many_virtual_thread {
    static void main() {
        for (int i = 1; i <= 1000; i++) {
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(100);
                } catch (Exception ignored) {
                }
            });
        }

        System.out.println("Started 1000 virtual threads!");
    }
}
