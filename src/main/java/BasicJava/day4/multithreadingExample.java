package BasicJava.day4;

public class multithreadingExample {
    public static void main(String[] args) throws InterruptedException {
//        Print print1 = new Print(1, 100); // one thread will execute this task
//        Print print2 = new Print(2,100); // one thread will execute this task
//        Print print3 = new Print(2,100); // one thread will execute this task
//
//        Thread thread1 = new Thread(print1);
//        Thread thread2 = new Thread(print2);
//        Thread thread3 = new Thread(print2);
//        thread3.setPriority(Thread.MAX_PRIORITY);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread1.setPriority(Thread.NORM_PRIORITY);
//        thread1.setName("thread-1");
//        thread2.setName("thread-2");
//        thread3.setName("thread-3");
//        thread1.join(); // it forces the thread to wait for thread1 to finish
//        thread2.join(); // this will force the thread to wait till thread2 is finish
//        thread3.join();

    }

    public static int nextserial(){
          return 0;
    }

}

class Print implements Runnable{
    private Integer integerToPrint;
    private Integer numOfTimeToPrint;

    public Print(Integer _integerToPrint,Integer _numOfTimeToPrint){
        integerToPrint=_integerToPrint;
        numOfTimeToPrint=_numOfTimeToPrint;
    }

    @Override
    public void run() {
        for(int i=0;i<numOfTimeToPrint;i++)
            System.out.println(Thread.currentThread().getName() + " , "+integerToPrint);
    }
}