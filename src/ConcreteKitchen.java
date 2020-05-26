
import java.util.concurrent.Semaphore;

public class ConcreteKitchen implements Kitchen {

    private Thread[] threads;
    private Phylosoph[] phylosophArray;
    private Fork[] forkArray;
    private Semaphore semaphore;

    ConcreteKitchen() {

        phylosophArray = new Phylosoph[ARRAY_SIZE];
        forkArray = new Fork[ARRAY_SIZE];
        semaphore = new Semaphore(2, true);
        threads = new Thread[ARRAY_SIZE];
        fillForkArray();
        fillPhylosophArray();
    }

    private void fillPhylosophArray() {

        for (int i = 0; i < ARRAY_SIZE - 1; i++) {
            phylosophArray[i] = new Phylosoph(semaphore, forkArray[i], forkArray[i + 1]);
        }
        phylosophArray[4] = new Phylosoph(semaphore, forkArray[4], forkArray[0]);
    }

    private void fillForkArray() {

        for (int i = 0; i < 5; i++) {
            forkArray[i] = new Fork();
        }
    }

    void fillThreadArray(String[] names) {

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(phylosophArray[i], names[i]);
        }
    }

    void startThreads() {

        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }
    }

}
