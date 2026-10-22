// Collection choice: Queue<String> backed by ArrayDeque<>.
// It supports FIFO: offer() adds at the back, poll() removes from the front.
// Both operations are efficient without shifting every remaining element.
import java.util.ArrayDeque;
import java.util.Queue;

public class Exercise10ConcertQueue {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("Alice");
        queue.offer("Bob");
        queue.offer("Charlie");
        queue.offer("Diana");
        queue.offer("Eve");
        queue.offer("Frank");

        System.out.println("Entering: " + queue.poll());
        System.out.println("Entering: " + queue.poll());
        System.out.println("Remaining queue: " + queue);
    }
}
