package base.sort2;

//常见排序算法
public class Sort {
    public static void main(String[] args) {

        int[] arr = {8,5,3,1,9,4,6,2};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    /**
     *
     * @param a  待排序的数组
     *  冒泡排序：
     *      算法思想：1、比较相邻的元素，如果第一个比第二个大就交换位置
     *                2、对每对相邻的元素做相同的操作，直到数组最后一对，这样一趟下来最后一个元素即为最大值
     *                3、对所有元素重复以上步骤，除了最后一个
     *                4、重复步骤1-3，直到排序完成
     *
     *     算法分析：
     *          最佳情况：T(n) = O(n)
     *          最差情况：T(n) = O(n2)
     *          平均情况：T(n) = O(n2)
     */
    public static void bubbleSort(int[] a){
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     *
     * @param a   待排序的数组
     *   直接插入排序：
     *          算法思想：1、将第一个元素默认为已排序
     *                    2、从第二个元素开始，从后往前遍历已排序的元素，找到其合适的插入位置
     *                    3、重复2，直到所有元素排序完
     *
     *          算法分析：
     *               最佳情况：T(n) = O(n)
     *               最坏情况：T(n) = O(n2)
     *              平均情况：T(n) = O(n2)
     */
    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1] > a[j]){
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }else {
                    break;
                }
            }
        }
    }

    /**
     *
     * @param a   待排序的数组
     *       选择排序：
     *            算法思想：1、将待排序的数组分为两个部分，未排序和已排序，初始时已排序的部分为空
     *                      2、遍历未排序的元素找到其中的最小值，将最小值按顺序加入到已排序的队列
     *                      3、n-1趟后完成排序
     *
     *            算法分析：
     *
     *              最佳情况：T(n) = O(n2)
     *              最差情况：T(n) = O(n2)
     *              平均情况：T(n) = O(n2)
     */
    public static void selectSort(int[] a) {
        int minIndex = 0;           //设置最小数的索引
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]){    //找到最小数的索引
                    minIndex = j;
                }
            }
            int temp = a[minIndex];          //把最小数和i处的值交换位置
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }

    /**
     *
     * @param a  待排序的数组
     *    希尔排序：
     *        算法思想：1.选定一个增长量h，按照增长量h作为数据分组的依据，对数据进行分组；
     *                  2.对分好组的每一组数据完成插入排序；
     *                  3.减小增长量，最小减为1，重复第2步操作。
     *
     *        算法分析：
     *
     *              最佳情况：T(n) = O(nlog2 n)
     *              最坏情况：T(n) = O(nlog2 n)
     *              平均情况：T(n) =O(nlog2n)
     */
    public static void shellSort(int[] a) {
        int len = a.length;
        int temp;
        int gap = len / 2;
        while (gap > 0){
            for (int i = gap; i < len; i++) {
                temp = a[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && a[preIndex] > temp){
                    a[preIndex + gap] = a[preIndex];
                    preIndex -= gap;
                }
                a[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }

    /**
     *
     * @param a  待排序的数组
     *      归并排序：
     *           算法思想：1.尽可能的一组数据拆分成两个元素相等的子组，并对每一个子组继续拆分，直到拆分后的每个子组的元素个数是1为止。
     *                     2.将相邻的两个子组进行合并成一个有序的大组；
     *                     3.不断的重复步骤2，直到最终只有一个组为止。
     *           算法分析：
     *                  最佳情况：T(n) = O(n)
     *                  最差情况：T(n) = O(nlogn)
     *                  平均情况：T(n) = O(nlogn)
     */
    public static int[] assist;        //辅助数组
    public static void mergeSort(int[] a) {
        assist = new int[a.length];     //辅助数组初始化
        int low = 0;
        int high = a.length - 1;
        mergedSort(a, low, high);

    }

    private static void mergedSort(int[] a, int low, int high) {
        if (low >= high){
            return;
        }
        int mid = low + (high - low) / 2;
        mergedSort(a, low, mid);
        mergedSort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int index = low;
        int index1 = low;
        int index2 = mid + 1;
        while (index1 <= mid && index2 <= high){
            if (a[index1] < a[index2]){
                assist[index++] = a[index1++];
            }else {
                assist[index++] = a[index2++];
            }
        }
        while (index1 <= mid){
            assist[index++] = a[index1++];
        }
        while (index2 <= high){
            assist[index++] = a[index2++];
        }
        for (int i = low; i <= high; i++) {
            a[i] = assist[i];
        }
    }

    /**
     *
     * @param a    待排序的数组
     *     快速排序：
     *          算法思想：1、从数列中挑出一个元素，称为 “基准”（pivot ）；
     *                    2、重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     *                    在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     *                    3、递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *          算法分析：
     *
     *               最佳情况：T(n) = O(nlogn)
     *              最差情况：T(n) = O(n2)
     *              平均情况：T(n) = O(nlogn)
     */
}
