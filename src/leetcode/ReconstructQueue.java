package leetcode;

import java.util.*;

public class ReconstructQueue {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{06,1},{5,2}};
        int[][] res = reconstructQueue(people);
        //printArr(res);
    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o2[0] - o1[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });

        printArr(people);
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
            System.out.println(person[1]);
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void printArr(int[][] res){
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
