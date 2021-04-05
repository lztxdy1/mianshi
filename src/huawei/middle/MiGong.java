package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
 *
 *
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 0, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 *
 *
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
 *
 *
 * 本题含有多组数据。
 *
 * 输入描述:
 * 输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 *
 * 输出描述:
 * 左上角到右下角的最短路径，格式如样例所示。
 *
 * HJ43
 */
public class MiGong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = br.readLine())){
            String[] str = s.split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] map = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }

            String[] res = {""};
            getShortPath(map, 0, 0, "(0,0)\n", res);
            if (res[0].length() == 0) {
                System.out.println("(0,0)");
            }else {
                System.out.println(res[0].substring(0, res[0].length() - 1));
            }
        }
    }

    private static void getShortPath(int[][] map, int x, int y, String path, String[] res) {

        if ((x == map.length - 1) && (y == map[x].length - 1)) {
            if (map[x][y]==0)
                res[0]=path;
            return;
        }
        if (x > map.length - 1 || y > map[x].length - 1)
            return;

        if (x + 1 < map.length && map[x+1][y] == 0)
            getShortPath(map,x+1,y,path+"("+(x+1)+","+y+")\n",res);

        if (y + 1 < map[x].length && map[x][y+1] == 0)
            getShortPath(map,x,y+1,path+"("+x+","+(y+1)+")\n",res);
    }
}
