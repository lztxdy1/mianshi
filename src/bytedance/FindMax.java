package bytedance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），
 * 则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
 */
public class FindMax {
    static class node{
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] num = bf.readLine().split(" ");
            int x = Integer.parseInt(num[0]);
            int y = Integer.parseInt(num[1]);
            nodes.add(new node(x, y));
        }
        nodes.sort((n1, n2) -> n2.y - n1.y);
        PrintWriter out = new PrintWriter(System.out);
        ArrayList<node> res = new ArrayList<>();
        out.print(nodes.get(0).x + " " + nodes.get(0).y + "\n");
        int last_max = nodes.get(0).x;
        for(int i = 1; i < N; i++) {
            if(last_max <= nodes.get(i).x) {
                out.print(nodes.get(i).x + " " + nodes.get(i).y + "\n");
                last_max = nodes.get(i).x;
            }
        }
        out.flush();
    }
}
