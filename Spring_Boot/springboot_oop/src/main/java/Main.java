import logic.BubbleSort;
import logic.Sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sort<String> sort = new BubbleSort<>();
        System.out.println("result is " + sort.sort(Arrays.asList(args)));
    }
}
