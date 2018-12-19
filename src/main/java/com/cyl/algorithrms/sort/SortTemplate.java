package com.cyl.algorithrms.sort;

/**
 * 排序算法模板
 */
public abstract class SortTemplate {

    public abstract void sort(Comparable[] a);

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
        //String[] a = In.readStrings();
        //sort(a);
        //assert isSorted(a);
        //show(a);
    }
}
