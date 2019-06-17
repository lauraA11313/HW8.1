public class PrimeNumbersFinderThread implements Runnable {
    private double minNumber;
    private double maxNumber;
    private PrimeNumbersStorage storage;

    public PrimeNumbersFinderThread(double minNumber, double maxNumber, PrimeNumbersStorage storage) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.storage = storage;
    }


    public void run() {
        double[] foundPrimeNumbers = {};

        boolean isPrime;

        for(double i=getMinNumber(); i<getMaxNumber(); i++) {
            isPrime = true;

            if (i % 2 == 0) isPrime = false;
            for (int j = 3; j * j <= i; j += 2) {
                if (i % j == 0)
                    isPrime = false;
            }
            if (i == 2) isPrime = true;
            if (isPrime)
                foundPrimeNumbers=extendFoundPrimeNumsArray(i, foundPrimeNumbers);
            // ...
        }
        getStorage().addNumbers(foundPrimeNumbers);
    }

    public double [] extendFoundPrimeNumsArray(double primeToAdd, double [] foundPrimeNumbers){
        double[] newPrimesArray=new double[foundPrimeNumbers.length+1];
        for (int i=0; i<foundPrimeNumbers.length;i++)
            newPrimesArray[i]=foundPrimeNumbers[i];
        newPrimesArray[foundPrimeNumbers.length] = primeToAdd;
        return newPrimesArray;
    }




    public double getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(double minNumber) {
        this.minNumber = minNumber;
    }

    public double getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(double maxNumber) {
        this.maxNumber = maxNumber;
    }

    public PrimeNumbersStorage getStorage() {
        return storage;
    }

    public void setStorage(PrimeNumbersStorage storage) {
        this.storage = storage;
    }

}

