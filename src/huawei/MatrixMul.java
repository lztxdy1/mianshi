package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C
 *
 * HJ69
 */
public class MatrixMul {
    static BufferedReader bufferedReader;
    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while (null != (s = bufferedReader.readLine())){
            String s1 = bufferedReader.readLine();
            String s2 = bufferedReader.readLine();
            int x = Integer.parseInt(s);  //第一个矩阵的行
            int y = Integer.parseInt(s1); //第一个矩阵的列和第二个矩阵的行
            int z = Integer.parseInt(s2); //第二个矩阵的列
            int[][] matrix1 = getMatrix(x, y);
            int[][] matrix2 = getMatrix(y, z);
            System.out.println(matrixMul(matrix1, matrix2));
        }
    }

    private static StringBuilder matrixMul(int[][] matrix1, int[][] matrix2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                int temp = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    temp += matrix1[i][k] * matrix2[k][j];
                }
                stringBuilder.append(temp).append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1).append("\n");
        }
        return stringBuilder;
    }

    private static int[][] getMatrix(int row, int col) throws IOException {
        int[][] tempArr = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] tempStrArr = bufferedReader.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                tempArr[i][j] = Integer.parseInt(tempStrArr[j]);
            }
        }
        return tempArr;
    }
}
