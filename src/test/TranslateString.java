package test;

import java.util.HashMap;
import java.util.Map;

public class TranslateString {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        String s = "123456";
        System.out.println(translate(s));

    }

    public static String translate (String str) {
        String tempStr = "";
        try {
            tempStr = new String(str.getBytes("ISO-8859-1"), "GBK");
            tempStr = tempStr.trim();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return tempStr;
    }
}
