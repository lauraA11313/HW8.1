import java.util.Scanner;

public class Intervals {

    int min;
    int max;
    int threadsCount;
    PrimeNumbersStorage storage = new PrimeNumbersStorage();

    public void getIntervalAndThreadsCount() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите интервал поиска чисел:");
        System.out.println("min: ");
        min = scan.nextInt();
        System.out.println("max: ");
        max = scan.nextInt();
        System.out.println("Введите кол-во потоков:");
        threadsCount = scan.nextInt();
    }


    public Thread[] divideOnIntervals(Thread [] threads) {
        int interval = max - min;
        int leftover = interval % threadsCount;
        int dividableInterval = interval - leftover;
        double n;
        if (interval < (Math.pow(2, threadsCount))) {
            n = (dividableInterval) / threadsCount;
            threads[0] = new Thread(new PrimeNumbersFinderThread(min, (min + n + leftover), storage));
            min += n + leftover;
            for (int i = 1; i < threadsCount; i++) {
                threads[i] = new Thread(new PrimeNumbersFinderThread(min, (min + n), storage));
                min += n;
            }
        } else {
            int threadsDecrement = threadsCount - 1;
            n = dividableInterval * (Math.pow(2, threadsDecrement) / Math.pow(2, threadsCount));
            threads[0] = new Thread(new PrimeNumbersFinderThread(min, (min + n + leftover), storage));
            min += n + leftover;
            while (threadsDecrement >= 1) {
                for (int i = 1; i < threadsCount; i++) {
                    threadsDecrement--;
                    n = dividableInterval * (Math.pow(2, threadsDecrement) / Math.pow(2, threadsCount));
                    if (threadsDecrement == 1) {
                        threads[i] = new Thread(new PrimeNumbersFinderThread(min, (min + n), storage));
                        min += n;
                        threads[i + 1] = new Thread(new PrimeNumbersFinderThread(min, (min + n), storage));
                    }
                    threads[i] = new Thread(new PrimeNumbersFinderThread(min, (min + n), storage));
                    min += n;
                }
            }
        }
        return threads;
    }




    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getThreadsCount() {
        return threadsCount;
    }

    public void setThreadsCount(int threadsCount) {
        this.threadsCount = threadsCount;
    }
}


