package common;

class DisjointSet {
        private int[] p;
        private int n;
        private int[] rank;

        public DisjointSet(int n) {
            this.n = n;
            p = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                p[i] = i;
        }

        public void union(int x, int y) {
            link(find(x), find(y));
        }

        private void link(int x, int y) {
            if (rank[x] > rank[y]) {
                p[y] = x;
            } else {
                p[x] = y;
                if (rank[x] == rank[y])
                    rank[y]++;
            }
        }

        public int find(int x) {
            if (p[x] != x)
                p[x] = find(p[x]);
            return p[x];
        }
    }