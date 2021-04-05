package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 一个DNA序列由A/C/G/T四个字母的排列组合组成。
 * G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
 * 在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
 *
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
 *
 *   HJ63
 */
public class DNASeq {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = bf.readLine())){
            char[] dnaSeq = s.toCharArray();
            int k = Integer.parseInt(bf.readLine());
            System.out.println(getMaxRatioSeq(dnaSeq, k));
        }
    }

    private static String getMaxRatioSeq(char[] seq, int k) {
        int start = 0;
        int max = 0;
        for (int i = 0; i < seq.length - k; i++) {
            int count = 0;
            for (int j = 0; j < k; j++) {
                if (seq[i + j] == 'C' || seq[i + j] == 'G'){
                    count++;
                }
            }
            if (count > max){
                start = i;
                max = count;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < start + k; i++) {
            sb.append(seq[i]);
        }
        return sb.toString();
    }
}
