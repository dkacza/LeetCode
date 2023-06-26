import java.util.PriorityQueue;
import java.util.Queue;

public class CostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        long totalCost = 0;
        Queue<Integer> left = new PriorityQueue<>();
        Queue<Integer> right = new PriorityQueue<>();


        for (int i = 0; i < candidates; i++) {
            left.add(costs[i]);
        }
        for (int i = costs.length - 1; i >= costs.length - candidates && i >= candidates; i--) {
            right.add(costs[i]);
        }

        int nextLeft = candidates;
        int nextRight = costs.length - candidates - 1;

        for (int worker = 0; worker < k; worker++) {
            if ((!left.isEmpty() && right.isEmpty()) || left.peek() <= right.peek()) {
                totalCost += left.poll();

                if (nextLeft <= nextRight) {
                    left.add(costs[nextLeft]);
                    nextLeft++;
                }
            }
            else {
                totalCost += right.poll();

                if (nextLeft <= nextRight) {
                    right.add(costs[nextRight]);
                    nextRight--;
                }
            }
        }
        return totalCost;
    }
    public static void main(String[] args) {
        CostToHireKWorkers solution = new CostToHireKWorkers();
        int[] costs = new int[] {1,2,4,1};
        int k = 3, candidates = 3;
        long result = solution.totalCost(costs, k, candidates);
        System.out.println(result);

    }
}
