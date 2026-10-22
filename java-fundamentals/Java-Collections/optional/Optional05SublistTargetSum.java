import java.util.Arrays;
import java.util.List;

public class Optional05SublistTargetSum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 1, 5);
        int target = 6;
        boolean foundAny = false;

        // Extend a running sum from each starting index. This also works
        // when some inputs are negative, unlike a simple sliding window.
        for (int start = 0; start < numbers.size(); start++) {
            int sum = 0;
            for (int end = start; end < numbers.size(); end++) {
                sum += numbers.get(end);
                if (sum == target) {
                    // subList's end argument is exclusive.
                    System.out.println("Index " + start + "-" + end + ": "
                        + numbers.subList(start, end + 1));
                    foundAny = true;
                }
            }
        }
        if (!foundAny) {
            System.out.println("No matching sublists.");
        }
    }
}
