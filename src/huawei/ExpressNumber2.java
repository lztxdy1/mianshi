package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static huawei.ExpressNumber.getExpressNumber;

public class ExpressNumber2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while ((s = bufferedReader.readLine()) != null){
            String str = s.toString();
            System.out.println(getExpressNumber(str));
        }
    }

}
