import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> clonedNodes = new HashMap<>();
        return cloneDfs(node, clonedNodes);
    }

    private Node cloneDfs(Node current, Map<Node, Node> clonedNodes) {
        if (clonedNodes.containsKey(current)) {
            return clonedNodes.get(current);
        }

        Node copy = new Node(current.val);
        clonedNodes.put(current, copy);

        for (Node neighbor : current.neighbors) {
            copy.neighbors.add(cloneDfs(neighbor, clonedNodes));
        }

        return copy;
    }

    static class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }
}
