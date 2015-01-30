package faen.common;

import java.util.Arrays;

public class BiGraphMatch {
    static int m, n;
    static boolean[][] map;
    static int[] match1;
    static int[] match2;
    static boolean[] vst;

    public static int get(boolean[][] map) {
        m = map.length;
        n = map[0].length;
        BiGraphMatch.map = map;
        match1 = new int[m];
        match2 = new int[n];
        Arrays.fill(match1, -1);
        Arrays.fill(match2, -1);
        vst = new boolean[m];
        int re = 0;
        for (int i = 0; i < m; i++) {
            Arrays.fill(vst, false);
            re += find(i);
        }
        return re;
    }

    private static int find(int s) {
        for (int i = 0; i < n; i++) {
            if (map[s][i] && vst[i] == false) {
                vst[i] = true;
                if (match2[i] == -1 || find(match2[i]) == 1) {
                    match1[s] = i;
                    match2[i] = s;
                    return 1;
                }
            }
        }
        return 0;
    }
}