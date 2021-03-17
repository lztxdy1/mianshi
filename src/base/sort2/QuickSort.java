package base.sort2;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {5,7,6,2,9,3,8};
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public static void quickSort(int[] a){
        int low = 0;
        int high = a.length - 1;
        qSort(a, low, high);
    }

    private static void qSort(int[] a, int low, int high) {
        if (low > high){
            return;
        }
        int partition = partition(a, low, high);
        qSort(a, low, partition - 1);
        qSort(a, partition + 1, high);
    }

    private static int partition(int[] a, int low, int high) {
        int privot = a[low];
        while (low < high){
            while (high > low && a[high] >= privot){
                    high--;
                }
            a[low] = a[high];
            while (high > low && a[low] <= privot){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = privot;
        return low;
    }
}
