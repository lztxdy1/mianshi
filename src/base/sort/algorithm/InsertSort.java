package base.sort.algorithm;

import static base.sort.util.SortUtil.exchange;
import static base.sort.util.SortUtil.greater;

public class InsertSort {
    //对数组中的元素排序  插入排序
    public static void insertSort(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            //当前元素为a[i]，依次和前面的元素比较，找到一个小于等于a[i]的元素
            for (int j = i; j > 0; j--)
                if (greater(a[j - 1], a[j])) {
                    //交换元素
                    exchange(a, j - 1, j);
                }else {
                    //找到了该元素，结束
                    break;
                }
        }
    }




}
