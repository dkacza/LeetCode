import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, ArrayList<Integer>> groupMembers = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            if (groupMembers.get(groupSize) == null) {
                ArrayList<Integer> newGroup = new ArrayList<>();
                newGroup.add(i);
                groupMembers.put(groupSize, newGroup);
                continue;
            }
            ArrayList<Integer> currentUsers = groupMembers.get(groupSize);
            currentUsers.add(i);
            groupMembers.put(groupSize, currentUsers);
        }

        List<List<Integer>> groups = new ArrayList<>();
        for (int groupSize : groupMembers.keySet()) {
            ArrayList<Integer> members = groupMembers.get(groupSize);
            if (members.size() == groupSize) {
                groups.add(members);
                continue;
            }
            int groupsToAdd = members.size() / groupSize;
            int addingGroup = 0;
            int startIndex = 0;
            int endIndex= groupSize;
            while (addingGroup < groupsToAdd) {
                groups.add(members.subList(startIndex, endIndex));
                startIndex += groupSize;
                endIndex += groupSize;
                addingGroup++;
            }
        }
        return groups;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,3,3,3,3,1,3};
        new GroupPeople().groupThePeople(arr);
    }
}
