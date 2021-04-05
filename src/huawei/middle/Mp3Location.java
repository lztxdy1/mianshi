package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输入描述:
 * 输入说明：
 * 1 输入歌曲数量
 * 2 输入命令 U或者D
 *
 * 本题含有多组输入数据！
 *
 *
 * 输出描述:
 * 输出说明
 * 1 输出当前列表
 * 2 输出当前选中歌曲
 *
 * HJ64
 */
public class Mp3Location {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = br.readLine())) {
            int songNum = Integer.parseInt(s);
            char[] operate = br.readLine().toCharArray();
            int index = 1;
            int start = 1;
            for (char c : operate) {
                if (songNum <= 4) {
                    if (c == 'U') {
                        if (index == 1)  {
                            index = songNum;
                        }else {
                            index--;
                        }
                    }else if (c == 'D') {
                        if (index == songNum) {
                            index = 1;
                        }else {
                            index++;
                        }
                    }
                }
                if (songNum > 4) {
                    if (c == 'U') {
                        if (index == 1)  {
                            index = songNum;
                            start = songNum - 3;
                        }else if (index == start){
                            index--;
                            start--;
                        }else {
                            index--;
                        }
                    }else if (c == 'D') {
                        if (index == songNum) {
                            index = 1;
                            start = 1;
                        }else if (index == start + 3){
                            index++;
                            start++;
                        }else {
                            index++;
                        }
                    }
                }
            }
            StringBuilder res = new StringBuilder();
            for (int i = 1; i <= 4; i++) {
                if (songNum >= i) {
                    res.append(start + i - 1).append(" ");
                }
            }
            System.out.println(res.toString().trim());
            System.out.println(index);
        }
    }
}
