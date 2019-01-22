package com.cyl.algorithrms.queue;

/**
 * 基于二叉堆的优先队列
 */
public class MaxPQ<Key extends Comparable<Key>> {

    /**
     * 基于堆的完全二叉树
     */
    private Key[] pq;

    /**
     * 存储于pq[1..N]中，pq[0]没有使用
     */
    private int N = 0;

    /**
     * 创建初始容量为maxM的优先队列
     */
    @SuppressWarnings("unchecked")
    public MaxPQ(int maxN){
        pq = new Comparable<Key>[maxN + 1];
    }

    /**
     * 向优先队列中插入一个元素
     * @param v
     */
    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    /**
     * 返回队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 返回优先队列中的元素个数
     * @return
     */
    public int size(){
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
     * 上浮
     * @param k
     */
    private void swim(int k){
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 下沉
     * @param k
     */
    private void sink(int k){
        while (2 * k <= N) {
            int j = 2 * k;
            if(j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxPQ<String> maxPQ = new MaxPQ<>(5);
    }
}
