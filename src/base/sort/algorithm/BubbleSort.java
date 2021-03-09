package base.sort.algorithm;

import static base.sort.util.SortUtil.exchange;
import static base.sort.util.SortUtil.greater;

//冒泡排序
public class BubbleSort {
    public static void bubbleSort(Comparable[] a){
        boolean isOrder = false;     //标识是否排序完成
        for (int i = a.length - 1; i > 0; i--) {
            isOrder = true;          //默认排序完成
            for (int j = 0; j < i; j++) {
                if (greater(a[j], a[j + 1])){
                    exchange(a, j, j + 1);
                    isOrder = false;   //如果出现元素交换，则排序未完成
                }
            }
            if (isOrder){     //如果排序已完成，跳出循环
                break;
            }
        }
    }
}
