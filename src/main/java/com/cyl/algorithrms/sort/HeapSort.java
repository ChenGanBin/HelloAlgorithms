package com.cyl.algorithrms.sort;

/**
 * 堆排序
 * @author cyl
 */
public class HeapSort {

    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int k = N/2; k >= 1; k--) {
            sink(a, k, N);
        }

        while(N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    /**
     * 下沉
     * @param k
     */
    private static void sink(Comparable[] a, int k, int n){
        while (2 * k <= n) {
            int j = 2 * k;
            if(j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        //    在单行中打印数组
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        //    测试数组元素是否有序
        for (int i = 1; i < a.length; i++) {
            if(less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = "HEAPSORTEXAMPLE".split("");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
