import java.util.Arrays;
import java.util.List;

public class Exercise04FindLargest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(14, 3, 78, 45, 22, 91, 7, 56);
        int largest = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > largest) {
                largest = numbers.get(i);
            }
        }

        System.out.println("Largest number: " + largest);
    }
}
