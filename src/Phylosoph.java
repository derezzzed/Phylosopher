import java.util.concurrent.Semaphore;

class Phylosoph implements Runnable {

    private Semaphore semaphore;
    private Fork leftFork;
    private Fork rightFork;

    Phylosoph(Semaphore semaphore, Fork leftFork, Fork rightFork) {
        this.semaphore = semaphore;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void run() {
        while (true) {
            eat();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void eat() {
        try {
            semaphore.acquire();

            synchronized (leftFork) {
                leftFork.setFree(false);
                synchronized (rightFork) {
                    rightFork.setFree(false);
                    System.out.println("I AM " + Thread.currentThread().getName());

                    Thread.sleep(500);
                }
                rightFork.setFree(true);
            }
            leftFork.setFree(true);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(Thread.currentThread().getName() + " DID EAT");
            semaphore.release();
        }
    }
}