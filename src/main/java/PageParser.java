import java.util.Set;
import java.util.TreeSet;

public class PageParser {
    public int[] parsePages(String input) {
        String[] tokens = input.split("[ ,]");
        Set<Integer> set = new TreeSet<>();

        for (String token : tokens) {
            if (!token.isEmpty()) {
                if (token.contains("-")) {
                    String[] rangeParts = token.split("-");

                    int start = Integer.parseInt(rangeParts[0]);
                    int end = Integer.parseInt(rangeParts[1]);
                    for (; start<=end; start++) {
                        set.add(start);
                    }
                }
                else {
                    set.add(Integer.parseInt(token));
                }

            }
        }

        int[] res = new int[set.size()];
        sortDescending(set, res, res.length-1);

        return res;
    }

    private void sortDescending(Set<Integer> set, int[] arr, int n) {
        for (int i : set) {
            arr[n] = i;
            n--;
        }
    }
}
