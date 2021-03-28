package base.sort2;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] a = {5,7,6,8,3,2,9,1,4};
        sort(a);
        printArr(a);
    }

    private static void sort(int[] a) {
        int low = 0;
        int high = a.length - 1;
        quickSort(a, low, high);
    }

    private static void quickSort(int[] a, int low, int high) {

        if (low < high){
            int partition = partition(a, low, high);
            quickSort(a, low, partition - 1);
            quickSort(a, partition + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int privot = a[low];
        while (low < high){
            while (low < high && a[high] >= privot){
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= privot){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = privot;
        printArr(a);
        return low;
    }
    private static void printArr(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");

        }
        System.out.println();
    }
}
