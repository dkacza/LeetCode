// Problem 373 - Medium
// Find K Pairs with Smallest Sums

import java.util.*;

public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        List<List<Integer>> answer = new ArrayList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        minHeap.offer(new int[] {nums1[0] + nums2[0], 0, 0});
        visited.add(new Pair<Integer, Integer>(0, 0));

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int i = top[1];
            int j = top[2];
            answer.add(List.of(nums1[i], nums2[j]));

            if (i + 1 < m && !visited.contains(new Pair<Integer, Integer>(i + 1, j))) {
                minHeap.offer(new int[] {nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(new Pair<Integer, Integer>(i + 1, j));
            }
            if (j + 1 < n && !visited.contains(new Pair<Integer, Integer>(i, j + 1))) {
                minHeap.offer(new int[] {nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(new Pair<Integer, Integer>(i, j + 1));
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        KSmallestPairs solution = new KSmallestPairs();
        int[] nums1 = new int[] {1, 7, 11};
        int[] nums2 = new int[] {2, 4, 6};
        int k = 3;
        List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
        System.out.println(result);
    }
}
class Pair<T, U> {
    T first;
    U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}
