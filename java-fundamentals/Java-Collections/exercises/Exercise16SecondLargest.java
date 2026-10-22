import java.util.Arrays;
import java.util.List;

public class Exercise16SecondLargest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(34, 78, 23, 78, 91, 56, 91, 12);
        Integer largest = null;
        Integer secondLargest = null;

        for (int number : numbers) {
            if (largest == null || number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number < largest &&
                    (secondLargest == null || number > secondLargest)) {
                secondLargest = number;
            }
        }
        if (secondLargest == null) {
            System.out.println("There are fewer than two distinct values.");
        } else {
            System.out.println("Second largest unique value: " + secondLargest);
        }
    }
}
