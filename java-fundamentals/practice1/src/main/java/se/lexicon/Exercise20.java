package se.lexicon;

public class Exercise20 {
    public static void main(String[] args) {
        for (int number = 2; number <= 50; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }

        System.out.println();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int divisor = 2; divisor * divisor <= n; divisor++) {
            if (n % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}
