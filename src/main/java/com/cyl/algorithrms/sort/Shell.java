package com.cyl.algorithrms.sort;

/**
 * 希尔排序
 */
public class Shell {

    public static void sort(Comparable[] a) {
        //将a[]按升序排列
        int N = a.length;
        System.out.println("N="+N);
        int h = 1;
        while (h < N / 3) {
            // 1, 4, 13, 40, 121, 364, 1093......
            System.out.println("3*h+1之前h: "+h);
            h = 3 * h + 1;
            System.out.println("3*h+1之后h: "+h);
        }
        while (h >= 1) {
            //将数组变为h有序
            for (int i = h; i < N; i++) {
                //将a[i]插入到a[i-h], a[i-2h], a[i-3*h]...之中
                System.out.println("交换前h="+h+" i="+i);
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    System.out.println("交换h="+h+" i="+i+" j="+j);
                    exch(a, j, j-h);
                }
            }
            h = h / 3;
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
        String[] a = "SHELLSORTEXAMPLE".split("");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
