package common;


import java.util.*;

public class Util {
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {

        SPFA spfa = new SPFA(3);
        spfa.addEdge(0, 1, 1);
        spfa.addEdge(1, 2, -3);
        spfa.addEdge(2, 0, 1);

        System.out.println(spfa.reCompute(0));
        System.out.println(spfa.getDis(2));
    }


    /**
     * Shortest path faster algorithm
     *
     * @param times
     * @param N
     * @param K
     * @return
     */
    public static int SPFA(int[][] times, int N, int K) {
        HashMap<Integer, HashMap<Integer, Integer>> edges = new HashMap<>();
        for (int[] e : times) {
            edges.putIfAbsent(e[0], new HashMap<>());
            edges.get(e[0]).put(e[1], e[2]);
        }

        int INF = 1000000;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[K] = 0;
        HashSet<Integer> inq = new HashSet<>();
        inq.add(K);
        LinkedList<Integer> q = new LinkedList<>();
        q.add(K);
        while (!q.isEmpty()) {
            int cur = q.poll();
            inq.remove(cur);
            if (!edges.containsKey(cur)) {
                continue;
            }
            for (HashMap.Entry<Integer, Integer> entry : edges.get(cur).entrySet()) {
                int next = entry.getKey();
                int val = entry.getValue();
                if (dist[next] > val + dist[cur]) {
                    dist[next] = val + dist[cur];
                    if (inq.contains(next)) {
                        continue;
                    }
                    q.add(next);
                    inq.add(next);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(dist[i], max);
        }
        if (max == INF) {
            return -1;
        }
        return max;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public String toString() {
            return "" + val;
        }

        TreeNode(int x) {
            val = x;
        }
    }

    // Integer[] values = new Integer[]{1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3};
    public static TreeNode buildTree(Integer[] values) {
        TreeNode[] tr = new TreeNode[values.length];
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(values[0]);
        q.add(root);
        for (int i = 1; i < values.length; i += 2) {
            TreeNode p = q.poll();
            if (values[i] != null) {
                p.left = new TreeNode(values[i]);
                q.add(p.left);
            }
            if (values[i + 1] != null) {
                p.right = new TreeNode(values[i + 1]);
                q.add(p.right);
            }
        }
        return root;
    }
}
