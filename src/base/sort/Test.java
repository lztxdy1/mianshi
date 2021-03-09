package base.sort;

import static base.sort.algorithm.HeapSort.heapSort;
import static base.sort.util.SortUtil.printArr;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = {5,4,8,2,1,9,3};
        //insertSort(arr);      //插入排序
        //shellSort(arr);       //希尔排序
        //quickSort(arr);       //快速排序
        //bubbleSort(arr);      //冒泡排序
        //selectSort(arr);       //选择排序
        heapSort(arr);        //堆排序
        printArr(arr);

    }
}
