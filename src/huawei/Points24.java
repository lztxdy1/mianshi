package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 问题描述：给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利
 * 输入：
 * 4个1-10的数字。[数字允许重复，但每个数字仅允许使用一次，测试用例保证无异常数字。
 * 输出：
 *
 * true or false
 *
 * HJ67
 */
public class Points24 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bufferedReader.readLine())){
            String[] number = s.split(" ");
            int[] nums = new int[4];
            int[] signs = new int[4];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(number[i]);
            }

            boolean flag = false;
            for (int i = 0; i < nums.length; i++) {
                signs[i] = 1;
                if (dfs(nums, signs, nums[i], 24)){
                    flag = true;
                    break;
                }
                signs[i] = 0;
            }
            System.out.println(flag);
        }
    }

    private static boolean dfs(int[] nums, int[] signs, int v, int required) {
        boolean allVisited = true;
        for (int sign : signs) {
            if (sign == 0){
                allVisited = false;
            }
        }
        if (allVisited){
            return v == required;
        }
        for (int i = 0; i < nums.length; i++) {
            if (signs[i] == 0) {
                signs[i] = 1;
                if (dfs(nums, signs, v + nums[i], required)
                        || dfs(nums, signs, v - nums[i], required)
                        || dfs(nums, signs, v * nums[i], required)
                        || nums[i] != 0 && v % nums[i] == 0 && dfs(nums, signs, v / nums[i], required)) {
                    return true;
                }
                signs[i] = 0;
            }
        }
        return false;
    }
}
