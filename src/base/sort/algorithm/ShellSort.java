package base.sort.algorithm;

import static base.sort.util.SortUtil.exchange;
import static base.sort.util.SortUtil.greater;

public class ShellSort{
    //希尔排序
    public static void shellSort(Comparable[] a) {
        int len = a.length;
        //确定增长量h的最大值
        int h = 1;     //增长量
        while (h < len / 2){
            h = h * 2 + 1;
        }

        while (h >= 1){      //当增长量小于1，排序结束
            //找到待插入的元素
            for (int i = h; i < len; i++) {
                //a[i]就是待插入的元素
                //把a[i]插入到a[i+h],a[i+2h],a[i+3h],...序列中
                for (int j = i; j >= h; j -= h) {
                    //a[j]就是待插入元素，依次和a[j-h],a[j-2h],a[j-3h],...进行比较，
                    // 如果a[j]小，交换位置，如果不小于，a[j]大，则完成插入
                    if (greater(a[j - h], a[j])){
                        exchange(a, j, j - h);
                    }else {
                        break;
                    }
                }
            }
            h /= 2;
        }
    }
}
