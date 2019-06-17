public class PrimeNumbersStorage {
    private double[] numbers;
    boolean check=false;

    synchronized void addNumbers(double[] numbersToAdd) {

        if (check){
            double[] newNumbersArray=new double[numbers.length+(numbersToAdd.length)];
            for (int i=0; i<numbers.length;i++)
                newNumbersArray[i]=numbers[i];
            int j=0;
            for (int i=numbers.length; i<newNumbersArray.length;i++) {
                newNumbersArray[i] = numbersToAdd[j];
                j++;
            }

            setNumbers(newNumbersArray);
        }
        else {
            numbers=new double[numbersToAdd.length];
            for (int j=0; j<numbersToAdd.length;j++)
                numbers[j]=numbersToAdd[j];
            check=true;
        }
       /* for (int i=0;i<numbers.length;i++)
        System.out.print(numbers[i]+" ");*/
    }

    public String toString(PrimeNumbersStorage[] numbers){
        String result = "";
        for(int i=0; i<numbers.length;i++){
            result+=(numbers[i]+" ");
        }
        return result;
    }

    public double[] getNumbers() {
        return numbers;
    }

    public void setNumbers(double[] numbersToAdd) {
        numbers=new double[numbersToAdd.length];
        for (int j=0; j<numbersToAdd.length;j++)
            numbers[j]=numbersToAdd[j];
    }
}
