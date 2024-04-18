package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

import static java.nio.file.Files.copy;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{

    private final ReentrantLock lock = new ReentrantLock();
    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    @Override
    public void run() {
        // Acquire the lock to ensure thread-safe access to the copying process
        lock.lock();
        try {
           
            } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Always release the lock
            lock.unlock();
        }
    }
}
