import java.util.Date;

public class OptimizedPrimeFactorization extends PrimeFactorization {

    public OptimizedPrimeFactorization(int limit) {
        this.threadName = "Tìm STN theo cách tối ưu";
        this.limit = limit;
        this.startTime = new Date().getTime();
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public boolean isPrime(int number) { // triển khai hàm isPrime theo cách tối ưu
        if (number < 2)
            return false;
        if (number == 2)
            return true;
        if (number % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
