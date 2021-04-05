package huawei.middle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TongPeiFu2{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line=br.readLine())!=null){
            String s2= br.readLine();
            System.out.println(help(s2, line));
        }
    }

    public static boolean help(String s, String p){
        int sr = 0;
        int pr = 0;
        int st = -1;
        int match = 0;
        while(sr < s.length()){
            if(pr < p.length() && (s.charAt(sr)==p.charAt(pr) || p.charAt(pr)=='?')){
                pr++;
                sr++;
            }
            else if(pr < p.length() && p.charAt(pr)=='*'){
                st = pr;
                match = sr;
                pr++;
            }
            else if(st != -1){
                pr = st + 1;
                sr = ++match;
            }
            else{
                return false;
            }
        }
        while(pr<p.length() && p.charAt(pr)=='*'){
            pr++;
        }
        return pr == p.length();
    }
}
