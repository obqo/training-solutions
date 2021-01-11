package week11.week11d01;

public class DivisorFinder {

    public int findDivisors(int n) {
        int divisorsCount = 0;
        int original = n;
        while (n != 0) {
            int remainder = n % 10;
            if (original % remainder == 0) {
                divisorsCount++;
            }
            n /= 10;
        }
        return divisorsCount;
    }
}
