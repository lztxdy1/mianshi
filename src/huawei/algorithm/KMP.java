package huawei.algorithm;

public class KMP {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算模板串S在文本串T中出现了多少次
     * @param S string字符串 模板串
     * @param T string字符串 文本串
     * @return int整型
     */
    public static int kmp (String S, String T) {
        int i = 0;
        int j = -1;
        int count = 0;
        //构建next数组
        int[] next = new int[T.length() + 1];
        next[0] = -1;
        next[1] = 0;
        int sLen = S.length();
        int tLen = T.length();
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        while(i < sLen){
            if(j == -1 || t[i] == s[j]){
                i++;
                j++;
                next[i] = j;
            }else {
                j = next[j];
            }
        }

        for (int k = 0; k < next.length; k++) {
            System.out.println(next[k]);
        }
        i = j = 0;
        while(i < tLen){
            if(t[i] == s[j]){
                i++;
                j++;
                if(j == sLen){
                    j = next[j];
                    count++;
                }
            }else{
                j = next[j];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abab";
        String t = "abacabab";
        System.out.println(kmp(s, t));
    }
}

