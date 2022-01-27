import java.util.Date;

public class OptimizedPrimeFactorization implements Runnable {
    private String threadName = "Tìm STN theo cách tối ưu";
    private int number = 0;
    private int count = 0;
    private int limit;
    private Thread thread = new Thread(this);
    private long startTime;
    private double ellapsedTime;

    public OptimizedPrimeFactorization(int limit) {
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
            if (isPrimeOmtipized(number)){
                count++;
                String msg = threadName + ": số nguyên tố thứ "+ count + " là "+ number;
                System.out.println(msg);
            }
            number++;
        }
        stop();
        System.out.println(threadName + ": dừng chạy");
    }

    private boolean isPrimeOmtipized(int number){
        if (number <2)
            return false;
        if (number == 2)
            return true;
        if (number %2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(number); i+= 2){
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
