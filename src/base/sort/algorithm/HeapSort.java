package base.sort.algorithm;

import static base.sort.util.SortUtil.*;

public class HeapSort {
    static int len;            //声明全局变量，用于记录数组的长度
    public static void heapSort(Comparable[] a) {
        len = a.length - 1;
        if (len < 1){
            return;
        }
        //构建一个大根堆
        buildMaxHeap(a);
        printArr(a);
        //循环将堆顶元素与最后一个叶子节点交换位置，再重新调整大根堆
        while (len > 0){
            exchange(a, 0, len);
            System.out.println(len);

            len--;
            adjustHeap(a, 0);
            printArr(a);
        }
    }

    private static void buildMaxHeap(Comparable[] a) {
        //从最后一个飞叶子节点开始向上构造大根堆
        //i的左子树和右子树分别为2*i+1和2*i+2
        for (int i = (len / 2 - 1); i >= 0; i--) {
            adjustHeap(a, i);
        }
//        printArr(a);
    }
    //调整使之成为大根堆
    private static void adjustHeap(Comparable[] a, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len  && greater(a[i * 2 + 1], a[maxIndex])){
            maxIndex = i * 2 + 1;
        }
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && greater(a[i * 2 + 2], a[maxIndex])){
            maxIndex = i * 2 + 2;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置
        if (maxIndex != i){
            exchange(a, maxIndex, i);
            adjustHeap(a, maxIndex);
        }
    }


}
