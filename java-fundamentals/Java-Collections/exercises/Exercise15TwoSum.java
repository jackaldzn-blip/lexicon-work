import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise15TwoSum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 7, 11, 15, 4, 6);
        int target = 13;
        Set<Integer> seen = new HashSet<>();
        boolean found = false;
        for (int number : numbers) {
            int needed = target - number;
            if (seen.contains(needed)) { // Previous distinct position in the list.
                System.out.println(needed + " + " + number + " = " + target);
                found = true;
                break;
            }
            seen.add(number);
        }
        if (!found) {
            System.out.println("No pair found.");
        }
    }
}
