package base.sort.algorithm;

import static base.sort.util.SortUtil.exchange;
import static base.sort.util.SortUtil.lesser;

//快速排序
public class QuickSort {
    public static void quickSort(Comparable[] a) {
        int low = 0;
        int high = a.length - 1;
        qSort(a, low, high);
    }

    private static void qSort(Comparable[] a, int low, int high) {
        if (low >= high){
            return;
        }
        //对a数组中，从low到high的元素进行切分
        int partition = partition(a, low, high);
        //对左边分组中的元素进行排序
        qSort(a, low, partition - 1);
        //对右边分组中的元素进行排序
        qSort(a, partition + 1, high);

    }

    //对a数组中，从low到high的元素进行切分
    private static int partition(Comparable[] a, int low, int high) {
        Comparable key = a[low];  //把最左边的元素当做基准值
        int left = low;        //定义一个左侧指针，初始指向最左边的元素
        int right = high + 1;      //定义一个右侧指针，初始指向最右边的元素的下一个位置
        //进行切分
        while (true){
            //先从右往左扫描，找到一个比基准值小的元素
            while (lesser(key, a[--right])){   //循环停止，证明找到了一个比基准值小的元素
                if (right == low){
                    break;                    //已经扫描到最左边了，无序继续扫描
                }
            }
            //再从左往右扫描，找到一个比基准值大的元素
            while (lesser(a[++left], key)){    //循环停止，证明找到了一个比基准值大的元素
                if (left == high){
                    break;                     //已经扫描到了最右边了，无需继续扫描
                }
            }

            if (left >= right){
                //扫描完了所有元素，结束循环
                break;
            }else {
                //交换left和right索引处的元素
                exchange(a, left, right);
            }
        }
        //交换最后right索引处和基准值所在的索引处的值
        exchange(a, low, right);
        return right;               //right就是切分的界限
    }
}
