package base.sort.algorithm;

import static base.sort.util.SortUtil.exchange;
import static base.sort.util.SortUtil.greater;

//选择排序
public class SelectSort {
    public static void selectSort(Comparable[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;      //假设minIndex为最小值索引
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[minIndex], a[j])){
                    minIndex = j;   //记录最小值索引
                }
            }
            exchange(a, i, minIndex);         //交换索引i和索引minIndex处的值
        }
    }
}
