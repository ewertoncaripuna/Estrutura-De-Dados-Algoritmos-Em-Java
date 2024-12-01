import java.util.List;

public class Collections {
    public static boolean nextPermutation(List<Integer> data) {
        int k = data.size() - 2;
        while (k >= 0 && data.get(k) >= data.get(k + 1)) {
            k--;
        }
        if (k < 0) return false;

        int l = data.size() - 1;
        while (data.get(l) <= data.get(k)) {
            l--;
        }

        Collections.swap(data, k, l);
        Collections.reverse(data.subList(k + 1, data.size()));
        return true;
    }

    private static void swap(List<Integer> data, int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    private static void reverse(List<Integer> sublist) {
        int start = 0, end = sublist.size() - 1;
        while (start < end) {
            swap(sublist, start, end);
            start++;
            end--;
        }
    }
}