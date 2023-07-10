import java.util.Arrays;

public class MaximumNumberOfCoins {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int turns = piles.length / 3;
        int res = 0;
        for (int i = turns; i < piles.length; i += 2) res += piles[i];
        return res;
    }
}
