package zhangshangxianji;

/**
 * 掌上先机笔试题目
 * 题目描述：给定一个有序数组，把有序数组中的重复元素移动到数组末端，并且保证非重复部分的顺序性，重复部分不做考虑。
 */
public class SortArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,2,3,3,4,5,6,7,7,8,9,9};
        int[] result = removeDuplicateToTail(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] removeDuplicateToTail(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = arr[0];
        int startIndex = 1;
        int lastIndex = arr.length - 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                res[lastIndex--] = arr[i];
            }else {
                res[startIndex++] = arr[i];
            }
        }
        return res;
    }
}
