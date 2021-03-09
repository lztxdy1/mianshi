package base.sort.algorithm;

import static base.sort.util.SortUtil.exchange;
import static base.sort.util.SortUtil.greater;

//冒泡排序
public class BubbleSort {
    public static void bubbleSort(Comparable[] a){
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(a[j], a[j + 1])){
                    exchange(a, j, j + 1);
                }
            }
        }
    }
}
