import java.util.Date;

public abstract class PrimeFactorization implements Runnable{
    protected String threadName;
    protected int number = 0;
    protected int count = 0;
    protected int limit;
    protected Thread thread;
    protected long startTime;
    protected double ellapsedTime;


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

            // isPrime trong class này là abstract
            // isPrime trong được gọi trong đoạn code dưới đây là isPrime cụ thể từng lớp con triển khai

            if (isPrime(number)){
                count++;
                String msg = threadName + ": số nguyên tố thứ "+ count + " là "+ number;
                System.out.println(msg);
            }
            number++;
        }
        stop();
        System.out.println(threadName + ": dừng chạy");
    }

    // abstract method này được triển khai theo 2 cách khác nhau
    //  ở mỗi class con theo ý đồ của bài tập
    public abstract boolean isPrime(int number);

}
