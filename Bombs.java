import java.util.*;

public class Bombs {
    static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static Set<Integer> visited;
    public static int maximumDetonation(int[][] bombs) {

        for (int i = 0; i < bombs.length; i++) {
            graph.put(i, new ArrayList<>());
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) continue;
                if (checkWithinRange(bombs[i], bombs[j])) {
                    ArrayList<Integer> detonatedBombs = graph.get(i);
                    detonatedBombs.add(j);
                    graph.put(i, detonatedBombs);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < bombs.length; i++) {
            visited = new HashSet<>();
            visited.add(i);
            dfs(i);
            result = Math.max(result, visited.size());
        }
        return result;
    }
    // Depth First Search
    public static void dfs(int node) {
        ArrayList<Integer> children = graph.get(node);
        for (int child : children) {
            if (visited.contains(child)) continue;
            visited.add(child);
            dfs(child);
        }
    }
    // Check if bomb A can detonate bomb B
    public static boolean checkWithinRange(int[] bombA, int[] bombB) {
        int xCrdA = bombA[0];
        int yCrdA = bombA[1];
        int radiusA = bombA[2];

        int xCrdB = bombB[0];
        int yCrdB = bombB[1];
        int radiusB = bombB[2];

        double distance = Math.sqrt(Math.pow(xCrdA - xCrdB, 2) + Math.pow(yCrdA - yCrdB, 2));
        return radiusA >= distance;
    }

    public static void main(String[] args) {
        int[][] bombs = {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
        int[][] bombs2 = {{855,82,158},{17,719,430},{90,756,164},{376,17,340},{691,636,152},{565,776,5},{464,154,271},{53,361,162},{278,609,82},{202,927,219},{542,865,377},{330,402,270},{720,199,10},{986,697,443},{471,296,69},{393,81,404},{127,405,177}};
        int result = maximumDetonation(bombs2);
        System.out.println(result);
    }
}
