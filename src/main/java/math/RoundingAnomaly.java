package math;

import java.util.Random;

public class RoundingAnomaly {

    private final Random rnd = new Random();

    private double[] randomNumbers(int size, double max, int scale) {
        double[] numbers = new double[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Math.round(rnd.nextDouble() * max * Math.pow(10, scale)) / Math.pow(10, scale);
        }
        return numbers;
    }

    public double roundAfterSum(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return Math.round(sum);
    }

    public double sumAfterRound(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += Math.round(number);
        }
        return sum;
    }

    public double difference(int size, double max, int scale) {
        double[] numbers = randomNumbers(size, max, scale);
        return Math.abs(roundAfterSum(numbers)-sumAfterRound(numbers));
    }

    public static void main(String[] args) {
        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();
        double sum = 0;
        int count = 100;
        for (int i = 0; i < count; i++) {
            double diff = roundingAnomaly.difference(1000, 1_000_000, 5);
            sum += diff;
            System.out.println("Difference: " + diff);
        }
        System.out.println(sum / count);

    }
}
