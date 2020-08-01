package common;

public class SegTreeReursive {
    static class Node {
        int i, j;
        int sum;
        Node left, right;

        public Node(int i, int j, int sum, Node left, Node right) {
            this.i = i;
            this.j = j;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }
    }

    private int[] nums;
    private Node root;

    public SegTreeReursive(int[] nums) {
        this.nums = nums;
        root = buildTree(0, nums.length - 1);
    }

    private Node buildTree(int i, int j) {
        if (i == j) {
            return new Node(i, j, nums[i], null, null);
        }
        int mid = (i + j) / 2;
        Node left = buildTree(i, mid);
        Node right = buildTree(mid + 1, j);

        Node ret = new Node(i, j, left.sum + right.sum, left, right);
        return ret;
    }

    public void update(int t, int val) {
        update(root, t, val);
    }

    private void update(Node root, int t, int val) {
        if (root.i == t && root.j == t) {
            root.sum = val;
            return;
        }

        if (root.left != null && root.left.i <= t && t <= root.left.j) {
            update(root.left, t, val);
        }

        if (root.right != null && root.right.i <= t && t <= root.right.j) {
            update(root.right, t, val);
        }
        int sum = 0;
        if (root.left != null) {
            sum += root.left.sum;
        }
        if (root.right != null) {
            sum += root.right.sum;
        }
        root.sum = sum;
    }

    public int rangeSum(int i, int j) {
        return  0;
    }

//    private int rangeSum(Node root, int i, int j) {
//        int ret = 0;
//        if (root.j >= j) {
//            return rangeSum(root.left, i, root.j);
//        }
//        if (root.i <= i) {
//            return rangeSum()
//        }
//        if ()
//    }
}
