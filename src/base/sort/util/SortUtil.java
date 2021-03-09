package base.sort.util;

import java.util.Arrays;

public class SortUtil {
    //交换元素位置
    public static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //比较c1和c2的大小   c1大于c2返回true
    public static boolean greater(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }

    //比较c1和c2的大小   c1小于c2返回true
    public static boolean lesser(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    //输出比较元素
    public static void printArr(Comparable[] a){
        System.out.println(Arrays.toString(a));
    }
}
