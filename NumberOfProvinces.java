import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        // Initialize node array
        ArrayList<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            nodes.add(i);
        }
        int result = 0;
        while(!nodes.isEmpty()) {
            ArrayList<Integer> connectedNodes = new ArrayList<>();
            Map<Integer, Boolean> checkedNodes = new HashMap<>();

            int currentNode = nodes.get(0);
            connectedNodes.add(currentNode);
            checkedNodes.put(currentNode, false);
            int processed = 0;

            while (processed != checkedNodes.size()) {
                currentNode = connectedNodes.get(processed);

                for (int i = 0; i < isConnected.length; i++) {
                    boolean isNeighbour = isConnected[currentNode][i] == 1;
                    if (isNeighbour && !connectedNodes.contains(i)) {
                        connectedNodes.add(i);
                        checkedNodes.put(i, false);
                    }
                }
                checkedNodes.put(currentNode, true);
                processed++;
            }

            // Remove nodes from the list
            for (int node : connectedNodes) {
                int indexToDelete = nodes.indexOf(node);
                nodes.remove(indexToDelete);
            }
            result++;

        }
        return result;
    }
    public static void main(String[] args) {
        int[][] isConnected =  {
                {1, 1, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
        };

        int result = findCircleNum(isConnected);
        System.out.println(result);
    }
}
