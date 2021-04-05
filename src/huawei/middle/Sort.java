package huawei.middle;

/**
 *
 */
public class Sort {
    public static void main(String[] args) {
        int[] array = {5, 3 , 1, 4, 6};
        quickSort(array, 0, array.length - 1);
        printArray(array);
    }

    public static void quickSort(int[] arr, int low, int high){
        int pivotLoc;
        if (low < high){
            pivotLoc = partition(arr, low, high);
            quickSort(arr, low, pivotLoc - 1);
            quickSort(arr, pivotLoc + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        while (low < high){
            while (low < high && arr[high] >= pivot)
                high--;
            arr[low] = arr[high];

            while (low < high && arr[low] <= pivot)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        System.out.println();
        printArray(arr);
        return low;

    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
