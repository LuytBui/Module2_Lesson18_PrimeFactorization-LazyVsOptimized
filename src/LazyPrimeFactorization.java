import java.util.Date;

public class LazyPrimeFactorization implements Runnable {
    private String threadName = "Tìm STN theo cách chậm hơn";
    private int number = 0;
    private int count = 0;
    private int limit;
    private Thread thread = new Thread(this);
    private long startTime;
    private double ellapsedTime;

    public LazyPrimeFactorization(int limit) {
        this.limit = limit;
        startTime = new Date().getTime();
        thread.start();
    }


    public void stop(){
        long endTime = new Date().getTime();
        ellapsedTime = (double) (endTime - startTime) / 1000;
    }
    public double getEllapsedTime(){
        return ellapsedTime;
    }

    public int getCount() {
        return count;
    }

    public String getThreadName() {
        return threadName;
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        while (count < limit){
            if (isPrimeLazy(number)){
                count++;
                String msg = threadName + ": số nguyên tố thứ "+ count + " là "+ number;
                System.out.println(msg);
            }
            number++;
        }
        stop();
        System.out.println(threadName + ": dừng chạy");
    }

    private boolean isPrimeLazy(int number){
        if (number <2)
            return false;
        if (number == 2)
            return true;
        for (int i = 2; i < number; i+= 1){
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
