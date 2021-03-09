package base.sort.algorithm;

import static base.sort.util.SortUtil.lesser;

//归并排序
public class MergeSort {
    public static Comparable[] assist;   //辅助数组
    //对数组a中的元素排序
    public static void mergeSort(Comparable[] a){
        assist = new Comparable[a.length];
        int low = 0;
        int high = a.length - 1;
        mergedSort(a, low, high);
    }

    //对数组a中从low到high排序
    public static void mergedSort(Comparable[] a, int low, int high) {
        if (high <= low){
            return;
        }
        int mid = low + (high - low) / 2;
        //对low到mid之间的元素进行排序
        mergedSort(a, low, mid);
        //对mid+1到high之间的元素进行排序
        mergedSort(a, mid + 1, high);
        //对low到mid这种数据和mid+1到high这组数据进行归并
        merge(a, low, mid, high);
    }

    //对数组中，从low到mid这组数据和mid+1到high这组数据进行归并
    public static void merge(Comparable[] a, int low, int mid, int high) {
        //low到mid和mid+1到high归并到assist数组的对应索引处
        int index = low;         //初始化指针，指向填充assist数组的第一个位置
        int index1 = low;        //初始化指针，指向第一组数据的第一个元素
        int index2 = mid + 1;    //初始化指针，指向第二组数据的第一个元素
        //比较左右两组数据的第一个数据，哪个小就把哪个数据放到assist数组中
        while (index1 <= mid && index2 <= high){
            if (lesser(a[index1], a[index2])){
                assist[index++] = a[index1++];
            }else {
                assist[index++] = a[index2++];
            }
        }

        //如果第二组数据归并完毕，把剩余的第一组的数据放入assist数组
        while (index1 <= mid){
            assist[index++] = a[index1++];
        }
        //如果第一组数据归并完毕，把剩余的第二组的数据放入assist数组
        while (index2 <= high){
            assist[index++] = a[index2++];
        }
        //将assist中排序好的数据放到a数组中对应的位置
        for (int i = low; i <= high; i++) {
            a[i] = assist[i];
        }

    }
}
