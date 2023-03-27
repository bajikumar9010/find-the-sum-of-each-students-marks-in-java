import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Sample arrays
        int[] stu1 = {90, 80, 70};
        int[] stu2 = {85, 75, 95};
        int[] stu3 = {95, 90, 80};

        // Sum of marks in each array
        int sum1 = sum(stu1);
        int sum2 = sum(stu2);
        int sum3 = sum(stu3);

        // ArrayLists for each student
        ArrayList<Integer> stu1List = toArrayList(stu1);
        ArrayList<Integer> stu2List = toArrayList(stu2);
        ArrayList<Integer> stu3List = toArrayList(stu3);

        // HashMap with keys "stu1", "stu2", "stu3"
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        map.put("stu1", stu1List);
        map.put("stu2", stu2List);
        map.put("stu3", stu3List);

        // Sum of marks for each student using Java Stream API
        Map<String, Integer> sumMap = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> sum(entry.getValue())));

        System.out.println("Sum of marks for each student: " + sumMap);
    }

    // Helper method to sum elements in an array
    public static int sum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // Helper method to convert an array to an ArrayList
    public static ArrayList<Integer> toArrayList(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }
}
