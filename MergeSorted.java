import java.util.Arrays;

public class MergeSorted {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0) {
            return;
        }
        if (m <= 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums1.length);
            return;
        }

        int[] nums1tmp = Arrays.copyOf(nums1, nums1.length);

        int indexA = 0;
        int indexB = 0;
        for (int i = 0; i < nums1.length; i++) {
            if ((indexB >= n) || ((indexA < m) && (nums1tmp[indexA] < nums2[indexB]))) {
                nums1[i] = nums1tmp[indexA];
                indexA++;
            } else {
                nums1[i] = nums2[indexB];
                indexB++;
            }
        }

        printArr(nums1);
    }
    public static void printArr (int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
                continue;
            }
            System.out.print(arr[i] + ",");
        }
        System.out.print("]\n");
    }
    public static void main(String[] args) {
        int[] nums1 = new int[] {2, 0};
        int m = 1;
        int[] nums2 = new int[] {1};
        int n = 1;
        merge(nums1, m, nums2, n);
    }
}
