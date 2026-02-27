import java.util.Arrays;

public class PageParser {
    public int[] parsePages(String input) {
        String[] tokens = input.split("[ ,]");
        final int[] pages = new int[100];
        int count = 0;

        for (String token : tokens) {
            if (!token.isEmpty()) {
                if (token.contains("-")) {
                    String[] rangeParts = token.split("-");

                    int start = Integer.parseInt(rangeParts[0]);
                    int end = Integer.parseInt(rangeParts[1]);
                    for (; start<=end; start++) {
                        pages[count] = start;
                        count++;

                    }
                }
                else {
                    pages[count] = Integer.parseInt(token);
                    count++;
                }

            }
        }

        int[] res = Arrays.copyOfRange(pages, 0, count);
        sortDescending(res);

        return res;
    }

    private void sortDescending(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int mid = length / 2;

        for (int i = 0; i < mid; i++) {
            int temp = arr[i];

            arr[i] = arr[length-i-1];
            arr[length-i-1] = temp;
        }
    }
}
