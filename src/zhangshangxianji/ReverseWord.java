package zhangshangxianji;

/**
 * 翻转单词：
 *      单词定义：只含有英文小写字母空格隔开两个单词
 *      例如：输入  a hello2 abc word!
 *           输出  a hello2 cba word!
 *
 */
public class ReverseWord {
    public static void main(String[] args) {
        String s = "a hello2 abc word!";
        System.out.println(reverseWord(s));
    }

    private static String reverseWord(String s) {
        StringBuilder res = new StringBuilder();
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            if (!isWord(str[i])) {
                res.append(str[i]).append(" ");
            }else {
                for (int j = str[i].length() - 1; j >= 0; j--) {
                    res.append(str[i].charAt(j));
                }
                res.append(" ");
            }
        }
        return res.toString().trim();
    }
    public static boolean isWord(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < 'a' || s.charAt(i) > 'z') {
                return false;
            }
        }
        return true;
    }
}
