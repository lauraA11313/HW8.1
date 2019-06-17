import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        PrimeNumbersStorage st = new PrimeNumbersStorage();
        Intervals i = new Intervals();
        i.getIntervalAndThreadsCount();

        Thread[] threads = new Thread[i.threadsCount];
        threads=i.divideOnIntervals(threads);

            for (Thread thread : threads) {
                thread.start();
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        for (int k=0;k<st.getNumbers().length;k++)
           System.out.println(st.getNumbers()[k]);
        }
    }
