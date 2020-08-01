package common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

// Java version of next_permutation of c++ 

public class Permutation {
    private static void swap(int[] p, int i, int j) {
        int t = p[i];
        p[i] = p[j];
        p[j] = t;
    }

    private static void revert(int[] p, int m, int n) {
        while (m < n) {
            int t = p[m];
            p[m] = p[n];
            p[n] = t;
            m++;
            n--;
        }
    }

    public static boolean pre(int[] p) {
        boolean find = false;
        int i = 0;
        for (i = p.length - 1; i > 0; i--)
            if (p[i] < p[i - 1]) {
                find = true;
                break;
            }
        if (find == false)
            return false;
        int j = 0;
        for (j = i; j < p.length; j++)
            if (p[j] >= p[i - 1])
                break;
        swap(p, j - 1, i - 1);
        revert(p, i, p.length - 1);
        return true;
    }

    public static boolean next(int[] p) {
        boolean find = false;
        int i = 0;
        for (i = p.length - 1; i > 0; i--)
            if (p[i] > p[i - 1]) {
                find = true;
                break;
            }
        if (!find) {
            Arrays.sort(p);
            return false;
        }
        int j;
        for (j = p.length - 1; j > i - 1; j--)
            if (p[j] > p[i - 1])
                break;
        swap(p, i - 1, j);
        revert(p, i, p.length - 1);
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int len = 6;

        int[] p = new int[len];
        Random rand = new Random();
        for (int i = 0; i < len; i++)
            p[i] = rand.nextInt(len);
        Arrays.sort(p);
        LinkedList<M> lm1 = new LinkedList<M>();
        LinkedList<M> lm2 = new LinkedList<M>();
        do {
            lm1.addLast(new M(p));
        } while (next(p));
        Arrays.sort(p);
        revert(p, 0, p.length - 1);
        do {
            lm2.addFirst(new M(p));
        } while (pre(p));
        for (int i = 0; i < lm1.size(); i++) {
            System.out.print(Arrays.toString(lm1.get(i).p));
            System.out.print(Arrays.toString(lm2.get(i).p));
            System.out.println();
        }
        System.out.println(lm1.equals(lm2));
    }

    static class M {
        int[] p;

        public M(int[] q) {
            p = new int[q.length];
            for (int i = 0; i < p.length; i++)
                p[i] = q[i];
        }

        public boolean equals(Object o) {
            M m = (M) o;
            if (p.length != m.p.length)
                return false;
            for (int i = 0; i < p.length; i++)
                if (p[i] != m.p[i])
                    return false;
            return true;
        }
    }
}