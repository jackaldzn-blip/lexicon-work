import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Optional01RotateList {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int k = 2;
        rotateRight(numbers, k);
        System.out.println("Rotated: " + numbers);
        // Also demonstrate k > list size: 7 has the same effect as 2 on 5 items.
        List<Integer> another = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        rotateRight(another, 7);
        System.out.println("Rotated by 7: " + another);
    }

    private static <T> void rotateRight(List<T> values, int k) {
        if (values.isEmpty()) {
            return; // Do not divide by zero for an empty list.
        }
        int effectiveRotation = Math.floorMod(k, values.size());
        Collections.rotate(values, effectiveRotation);
    }
}
