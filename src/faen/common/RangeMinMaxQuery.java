package faen.common;

import java.util.Arrays;
import java.util.Random;

/**
 * 这个类的提供RangeMaxmumQuery和RangeMinimumQuery功能 方式使用线段数，非常好
 *
 * @author faen
 */
public class RangeMinMaxQuery {
    public static class MaxMin {
        public int max_index, min_index;

        public MaxMin(int a, int b) {
            max_index = a;
            min_index = b;
        }

        @Override
        public String toString() {
            return "MaxMin{" +
                    "max_index=" + max_index +
                    ", min_index=" + min_index +
                    '}';
        }
    }

    private int[] p;
    private MaxMin[] mm;

    public RangeMinMaxQuery(int[] p) {
        this.p = p;
        // (int)(Math.log(N) / Math.log(2));
        // https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
        // 2 * (2^(ceil(log2(p.length))) - 1
        // the worst case is : p.length == 2^n + 1, e.g. 9, 17
        int segmentTreeSize = (int) (2 * Math.pow(2, Math.ceil(Math.log(p.length) / Math.log(2))));
        //System.out.println(p.length + " " + segmentTreeSize + " " + (double)segmentTreeSize/p.length);
        mm = new MaxMin[segmentTreeSize];
    }

    /**
     * 更改数组中某个元素的值
     *
     * @param index
     * @param value
     */

    public void update(int index, int value) {
        p[index] = value;
        clear(1, 0, p.length - 1, index);
    }

    /**
     * 把牵涉到的点赋值null，以后用的时候会重新计算
     *
     * @param ci
     * @param left
     * @param right
     * @param index
     */

    private void clear(int ci, int left, int right, int index) {
        mm[ci] = null;
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        if (index <= mid) {
            clear(ci * 2, left, mid, index);
        } else {
            clear(ci * 2 + 1, mid + 1, right, index);
        }
    }

    /**
     * query
     *
     * @param x
     * @param y
     * @return
     */
    public MaxMin calc(int x, int y) {
        if (x < 0 || y >= p.length || x > y)
            return null;
        return calc(1, 0, p.length - 1, x, y);
    }

    /**
     * 一次计算得到区间中最大和最小值的下标
     *
     * @param ci
     * @param left
     * @param right
     * @param x
     * @param y
     * @return
     */
    private MaxMin calc(int ci, int left, int right, int x, int y) {
        if (left == x && right == y) {
            if (mm[ci] != null)
                return mm[ci];
            if (left == right)
                return mm[ci] = new MaxMin(left, left);
            int mid = (left + right) / 2;
            MaxMin mm1 = calc(2 * ci, left, mid, left, mid);
            MaxMin mm2 = calc(2 * ci + 1, mid + 1, right, mid + 1, right);
            return mm[ci] = makeFromTwo(mm1, mm2);
        }
        int mid = (left + right) / 2;
        if (x >= mid + 1)
            return calc(ci * 2 + 1, mid + 1, right, x, y);
        else if (y <= mid)
            return calc(ci * 2, left, mid, x, y);
        else {
            MaxMin mm1 = calc(2 * ci, left, mid, x, mid);
            MaxMin mm2 = calc(2 * ci + 1, mid + 1, right, mid + 1, y);
            return makeFromTwo(mm1, mm2);
        }
    }

    private MaxMin makeFromTwo(MaxMin mm1, MaxMin mm2) {
        int a, b;
        if (p[mm1.max_index] < p[mm2.max_index])
            a = mm2.max_index;
        else
            a = mm1.max_index;
        if (p[mm1.min_index] > p[mm2.min_index])
            b = mm2.min_index;
        else
            b = mm1.min_index;
        return new MaxMin(a, b);
    }

    public static void main(String[] args) throws Exception {
        for (int k = 1000000; k <= 1000000; k++) {
            int len = k;
            int[] p = new int[len];
            Random rand = new Random();
            for (int i = 0; i < len; i++) {
                p[i] = rand.nextInt(len);
            }
            RangeMinMaxQuery rmq = new RangeMinMaxQuery(p);
            for (int ts = 0; ts < 1000; ts++) {
                for (int u = 0; u < 3; u++) {
                    int v = rand.nextInt(len);
                    int index = rand.nextInt(len);
                    rmq.update(index, v);
                }
                int x = rand.nextInt(len);
                int y = rand.nextInt(len);
                int a = Math.min(x, y);
                int b = Math.max(x, y);
                MaxMin mm = rmq.calc(a, b);

//                System.out.println(Arrays.toString(p));
//                for (int i = a; i <= b; i++) {
//                    System.out.print(p[i] + ", ");
//                }
//                System.out.println();
//                System.out.println(mm + ", max value:" + p[mm.max_index] + ", min value:" + p[mm.min_index]);
//                System.out.println("-----------------");
                for (int i = a; i <= b; i++) {
                    if (p[i] > p[mm.max_index])
                        throw new Exception("adf");
                    if (p[i] < p[mm.min_index])
                        throw new Exception("adf");
                }
            }
        }
    }
}
