import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;

public class Exercise08MergeWithoutDuplicates {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> b = Arrays.asList(3, 4, 5, 6, 7);
        Set<Integer> merged = new LinkedHashSet<>(a);
        merged.addAll(b);
        System.out.println("Merged: " + merged);
        System.out.println("Count: " + merged.size());
    }
}
