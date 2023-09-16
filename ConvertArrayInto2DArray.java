import java.util.*;
import java.util.stream.Collectors;

public class ConvertArrayInto2DArray {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<Set<Integer>> matrix = new LinkedList<>();
        Arrays.stream(nums).forEach(number -> {
            boolean insertedIntoExisting = false;
            for (Set<Integer> row : matrix) {
                if (row.contains(number)) continue;
                row.add(number);
                insertedIntoExisting = true;
                break;
            }

            if (insertedIntoExisting) return;
            Set<Integer> newRow = new HashSet<>();
            newRow.add(number);
            matrix.add(newRow);


        });

        return matrix.stream().map(LinkedList::new).collect(Collectors.toList());
    }
}
