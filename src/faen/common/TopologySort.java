package common;

import java.util.*;

public class TopologySort {
    int[] inCount;
    private HashMap<Integer, HashSet<Integer>> edges = new HashMap<>();

    public TopologySort(int n) {
        inCount = new int[n];
    }

    public void addEdge(int from, int to) {
        edges.putIfAbsent(from, new HashSet<>());
        edges.get(from).add(to);
        inCount[to]++;
    }

    List<Integer> compute() {
        List<Integer> ret = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < inCount.length; i++) {
            if (inCount[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int from = q.poll();
            ret.add(from);
            for (int to : edges.getOrDefault(from, new HashSet<>())) {
                inCount[to]--;
                if (inCount[to] == 0) {
                    q.add(to);
                }
            }
        }
        return ret;
    }
}
