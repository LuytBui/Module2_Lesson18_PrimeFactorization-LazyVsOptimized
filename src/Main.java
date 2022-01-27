public class Main {

    public static final int LIMIT = 20000;

    public static void main(String[] args) {
        OptimizedPrimeFactorization opf = new OptimizedPrimeFactorization(LIMIT);
        LazyPrimeFactorization lpf = new LazyPrimeFactorization(LIMIT);

        while(opf.getThread().isAlive() || lpf.getThread().isAlive()){
            // chờ cho 2 thread chạy xong
        }

        System.out.println("-------------------------------");

        System.out.println(opf.getThreadName() + ": tìm được " + LIMIT + " STN trong thời gian " + opf.getEllapsedTime() + "s");
        System.out.println(lpf.getThreadName() + ": tìm được " + LIMIT + " STN trong thời gian " + lpf.getEllapsedTime() + "s");

    }
}
