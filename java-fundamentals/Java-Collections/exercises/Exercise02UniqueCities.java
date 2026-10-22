import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Exercise02UniqueCities {
    public static void main(String[] args) {
        Set<String> uniqueCities = new TreeSet<>(Arrays.asList(
                "Stockholm", "Gothenburg", "Malmö", "Stockholm",
                "Uppsala", "Gothenburg", "Lund"));
        // TreeSet removes duplicates AND prints in alphabetical order.
        System.out.println("Unique cities: " + uniqueCities);
        System.out.println("Count: " + uniqueCities.size());
    }
}
