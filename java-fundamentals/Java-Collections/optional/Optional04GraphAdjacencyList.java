import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Optional04GraphAdjacencyList {
    private final HashMap<String, List<String>> graph = new HashMap<>();

    private void addNode(String node) {
        graph.putIfAbsent(node, new ArrayList<>());
    }

    private void addUndirectedEdge(String a, String b) {
        addNode(a);
        addNode(b);
        if (!graph.get(a).contains(b)) {
            graph.get(a).add(b);
        }
        if (!graph.get(b).contains(a)) {
            graph.get(b).add(a);
        }
    }

    private void printNeighbours(String node) {
        List<String> neighbours = graph.get(node);
        if (neighbours == null) {
            System.out.println("Unknown node: " + node);
        } else {
            System.out.println(node + " neighbours: " + neighbours);
        }
    }

    private boolean directlyConnected(String a, String b) {
        List<String> neighbours = graph.get(a);
        return neighbours != null && neighbours.contains(b);
    }

    public static void main(String[] args) {
        Optional04GraphAdjacencyList network = new Optional04GraphAdjacencyList();
        for (String node : Arrays.asList("A", "B", "C", "D", "E")) {
            network.addNode(node);
        }
        // Six undirected edges among five nodes.
        network.addUndirectedEdge("A", "B");
        network.addUndirectedEdge("A", "C");
        network.addUndirectedEdge("B", "C");
        network.addUndirectedEdge("B", "D");
        network.addUndirectedEdge("C", "E");
        network.addUndirectedEdge("D", "E");

        network.printNeighbours("B");
        System.out.println("A and C connected? " + network.directlyConnected("A", "C"));
        System.out.println("A and E connected? " + network.directlyConnected("A", "E"));
    }
}
