package faen.common;

import java.util.*;

public class SimplexNew {
    static double[][] A;

    static double[] b;

    static double[] c;

    static double[] res;

    static int[] kt = new int[0];

    static int[] N;

    static int m;

    static double EPS = 1e-10;

    static double INF = Double.MAX_VALUE;

    static void pivot(int k, int l, int e) {
        int x = kt[l];
        double p = A[l][e];
        for (int i = 0; i < k; i++)
            A[l][i] /= p;
        b[l] /= p;
        N[e] = 0;
        for (int i = 0; i < m; i++)
            if (i != l) {
                b[i] -= A[i][e] * b[l];
                A[i][x] = A[i][e] * -A[l][x];
            }
        for (int j = 0; j < k; j++)
            if (N[j] != 0) {
                c[j] -= c[e] * A[l][j];
                for (int i = 0; i < m; i++)
                    if (i != l)
                        A[i][j] -= A[i][e] * A[l][j];
            }
        kt[l] = e;
        N[x] = 1;
        c[x] = c[e] * -A[l][x];
    }

    static double[] resize(double[] src, int size, double dft) {
        double[] res = new double[size];
        Arrays.fill(res, dft);
        for (int i = 0; i < Math.min(src.length, size); i++)
            res[i] = src[i];
        return res;
    }

    static double[] resize(double[] src, int size) {
        return resize(src, size, 0);
    }

    static int[] resize(int[] src, int size, int dft) {
        int[] res = new int[size];
        Arrays.fill(res, dft);
        for (int i = 0; i < Math.min(src.length, size); i++)
            res[i] = src[i];
        return res;
    }

    static int[] resize(int[] src, int size) {
        return resize(src, size, 0);
    }

    static double[] doit(int k) {
        double[] res = new double[0];
        double best = 0;
        while (true) {
            int e = -1, l = -1;
            for (int i = 0; i < k; i++)
                if (N[i] != 0 && c[i] > EPS) {
                    e = i;
                    break;
                }
            if (e == -1)
                break;
            for (int i = 0; i < m; i++)
                if (A[i][e] > EPS && (l == -1 || best > b[i] / A[i][e]))
                    best = b[l = i] / A[i][e];
            if (l == -1)
                return new double[0];
            pivot(k, l, e);
        }
        res = resize(res, k, 0);
        for (int i = 0; i < m; i++)
            res[kt[i]] = b[i];
        return res;
    }

    /*
     * A*x<=b, maksymalizujemy x*c (a[0][0]*x[0]+a[0][1]*x[1]+...<=b[0]), dla
     * x>=0
     */
    static double[] simplex(double[][] AA, double[] bb, double[] cc) {
        int n = AA[0].length, k;
        m = AA.length;
        k = n + m + 1;
        kt = resize(kt, m);
        b = bb;
        c = cc;
        c = resize(c, n + m);
        A = AA;
        for (int i = 0; i < m; i++) {
            A[i] = resize(A[i], k);
            A[i][n + i] = 1;
            A[i][k - 1] = -1;
            kt[i] = n + i;
        }
        N = new int[k];
        Arrays.fill(N, 1);
        for (int i = 0; i < m; i++)
            N[kt[i]] = 0;
        int pos = 0;
        double min_element = INF;
        for (int i = 0; i < b.length; i++) {
            if (b[i] < min_element) {
                min_element = b[i];
                pos = i;
            }
        }
        if (b[pos] < -EPS) {
            c = new double[k];
            c[k - 1] = -1;
            pivot(k, pos, k - 1);
            res = doit(k);
            if (res[k - 1] > EPS)
                return new double[0];
            for (int i = 0; i < m; i++)
                if (kt[i] == k - 1)
                    for (int j = 0; j < k - 1; j++)
                        if (N[j] != 0 && (A[i][j] < -EPS || EPS < A[i][j])) {
                            pivot(k, i, j);
                            break;
                        }
            c = cc;
            c = resize(c, k, 0);
            for (int i = 0; i < m; i++)
                for (int j = 0; j < k; j++)
                    if (N[j] != 0)
                        c[j] -= c[kt[i]] * A[i][j];
        }
        res = doit(k - 1);
        if (!(res.length == 0))
            res = resize(res, n);
        return res;
    }

    public static void main(String[] args) {
        /**
         * maximize: 3x1 + x2 + 2x3 constrains: x1 + x2 + 3x3 <= 30 2x1 + 2x2 +
         * 5x3 <= 24 4x1 + x2 + 2x3 <= 36 x1,x2,x3 >=0
         */
        double[][] A = { { 1, 1, 3 }, { 2, 2, 5 }, { 4, 1, 2 } };
        double[] b = { 30, 24, 36 };
        double[] c = { 3, 1, 2 };
        double[] x = simplex(A, b, c);
        double res = 0;
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
            res += c[i] * x[i];
        }
        System.out.println();
        System.out.println(res);

    }
}