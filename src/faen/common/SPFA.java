package common;

import java.util.*;

/**
 * shortest path faster algorithm
 */
public class SPFA {
    private int n;
    private int[] dis;
    private int[] count;

    public final int INF = 100000000;

    private HashMap<Integer, HashMap<Integer, Integer>> edges = new HashMap<>();

    /**
     * number of Node: n
     *
     * @param n
     */
    public SPFA(int n) {
        this.n = n;
        this.dis = new int[n];
        this.count = new int[n];
    }

    /**
     * @param from  [0, n)
     * @param to    [0, n)
     * @param value
     */
    public void addEdge(int from, int to, int value) {
        edges.putIfAbsent(from, new HashMap<>());
        edges.get(from).put(to, value);
    }

    /**
     * @param source
     * @return if negtive circle doesn't exist; return true if it exits
     */
    public boolean reCompute(int source) {
        LinkedList<Integer> q = new LinkedList<>();
        HashSet<Integer> inQ = new HashSet<>();
        Arrays.fill(dis, INF);
        q.add(source);
        inQ.add(source);
        dis[source] = 0;
        count[source]++;

        while (!q.isEmpty()) {
            int from = q.poll();
            inQ.remove(from);
            if (!edges.containsKey(from)) {
                continue;
            }
            for (Map.Entry<Integer, Integer> entry : edges.get(from).entrySet()) {
                int to = entry.getKey();
                int value = entry.getValue();
                if (dis[to] > dis[from] + value) {
                    dis[to] = dis[from] + value;
                    if (!inQ.contains(to)) {
                        inQ.add(to);
                        q.add(to);
                        count[to]++;
                        if (count[to] >= n) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int getDis(int to) {
        return dis[to];
    }
}