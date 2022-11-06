import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1,2,2,3,3,3,4,4,4,4,5,5,5,5,5);
        Set<Integer> set = new HashSet<>(ls);
        System.out.println(set);
    }
}
