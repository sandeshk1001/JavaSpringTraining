package BasicJava.day4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FindSerialNumber {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        PrintSerialNo print = new PrintSerialNo(100);
        executorService.execute(print);
        executorService.execute(print);
        executorService.shutdownNow();
    }
}

class PrintSerialNo implements Runnable {
    public static volatile int last;

    public PrintSerialNo(Integer _last) {
        last =_last;
    }

    @Override
    public void run() {
        for (int count = 0; count<= last; count++){
            synchronized (this) {
                System.out.println(count + " ");
            }
        }
    }
}