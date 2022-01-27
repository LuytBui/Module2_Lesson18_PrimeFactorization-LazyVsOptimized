import java.util.Date;

public class LazyPrimeFactorization extends PrimeFactorization {

    public LazyPrimeFactorization(int limit) {
        this.threadName = "Tìm STN theo cách chậm hơn";
        this.limit = limit;
        this.startTime = new Date().getTime();
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public boolean isPrime(int number) { // triển khai hàm isPrime theo cách chậm
        if (number < 2)
            return false;
        if (number == 2)
            return true;
        for (int i = 2; i < number; i += 1) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
