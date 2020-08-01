package common;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 注意此题要求任意两个顶点间只有一条边,虽然是有向图。
 * 
 * @author faen
 * 
 */
public class MinimumCostFlow {

    private int[][] cap;
    private int[][] cost;
    private int n;
    private int[] back;
    private int[] best;
    private int maxFlow = 0;

    public MinimumCostFlow(int[][] cap, int[][] cost) {
        this.cap = cap;
        this.cost = cost;
        this.n = cap.length;
        init();
        back = new int[n];
        best = new int[n];
    }

    private void init() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (cap[i][j] > 0)
                    cost[j][i] = -cost[i][j];
        maxFlow = 0;
    }

    public int get(int src, int dest) {
        int re = 0;
        while (true) {
            AugRe ar = aug(src, dest);
            if (ar == null)
                break;
            re += ar.minCost;
            maxFlow += ar.minCap;
        }
        return re;
    }

    public int getMaxFlow() {
        return maxFlow;
    }

    private AugRe aug(int src, int dest) {
        Arrays.fill(back, -1);
        back[src] = src;
        Arrays.fill(best, Integer.MAX_VALUE);
        best[src] = 0;
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(src);
        while (!q.isEmpty()) {
            int cur = q.remove(0);
            int cb = best[cur];
            for (int i = 0; i < n; i++)
                if (cap[cur][i] > 0) {
                    if (cb + cost[cur][i] < best[i]) {
                        best[i] = cb + cost[cur][i];
                        back[i] = cur;
                        q.add(i);
                    }
                }
        }
        if (best[dest] == Integer.MAX_VALUE)
            return null;
        int minCap = Integer.MAX_VALUE;
        int cur = dest;
        while (back[cur] != cur) {
            minCap = Math.min(cap[back[cur]][cur], minCap);
            cur = back[cur];
        }
        cur = dest;
        while (back[cur] != cur) {
            cap[back[cur]][cur] -= minCap;
            cap[cur][back[cur]] += minCap;
            cur = back[cur];
        }
        AugRe augre = new AugRe(best[dest] * minCap, minCap);
        return augre;
    }

    private static class AugRe {
        int minCost, minCap;

        public AugRe(int minCost, int minCap) {
            this.minCost = minCost;
            this.minCap = minCap;
        }
    }

}