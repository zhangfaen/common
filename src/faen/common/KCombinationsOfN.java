package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KCombinationsOfN {
   private static List<List<Integer>> output = new ArrayList<>();
    private static LinkedList<Integer> tmpList = new LinkedList<>();
    private static   int[] arr;

    private static void dfs(int cur, int k) {
        if (k == 0) {
            output.add(new LinkedList<>(tmpList));
            return;
        }
        if (cur == arr.length) {
            return;
        }
        dfs(cur + 1, k);
        tmpList.addLast(arr[cur]);
        dfs(cur + 1, k - 1);
        tmpList.removeLast();
    }

    public static List<List<Integer>> combine(int[] arr, int k) {
        KCombinationsOfN.arr = arr;
        dfs(0, k);
        return output;
    }

    public static void main(String[] args) {
        int[] p = new int[5];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        System.out.println(combine(p, 5));
    }
}
