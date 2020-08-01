package common;

public class SegTree {
    private int[] nums;
    private int n;
    private int[] nodes;

    public SegTree(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        buildTree();
    }

    private void buildTree() {
        this.nodes = new int[2 * n];
        for (int i = n, j = 0; i < 2 * n; i++, j++) {
            nodes[i] = nums[j];
        }
        for (int i = n - 1; i > 0; i--) {
            nodes[i] = nodes[i * 2] + nodes[i * 2 + 1];
        }
    }

    public void update(int i, int val) {
        int cur = i + n;
        nodes[cur] = val;
        while (cur > 0) {
            int root = cur / 2;
            nodes[root] = nodes[2 * root] + nodes[2 * root + 1];
            cur /= 2;
        }
    }

    // sum of nums[i, j]
    public int sumRange(int i, int j) {
        i += n;
        j += n;
        int sum = 0;
        while (i <= j) {
            if (i % 2 == 1) {
                sum += nodes[i];
                i++;
            }
            if (j % 2 == 0) {
                sum += nodes[j];
                j--;
            }
            i /= 2;
            j /= 2;
        }
        return sum;
    }
}
