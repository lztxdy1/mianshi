package huawei.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 *
 * 链表的值不能重复。
 *
 * 构造过程，例如
 *
 * 1 <- 2
 *
 * 3 <- 2
 *
 * 5 <- 1
 *
 * 4 <- 5
 *
 * 7 <- 2
 *
 * 最后的链表的顺序为 2 7 3 1 5 4
 *
 * 删除 结点 2
 *
 * 则结果为 7 3 1 5 4
 *
 * 链表长度不大于1000，每个节点的值不大于10000。
 * 本题含有多组样例。
 *
 * 输入描述:
 * 1 输入链表结点个数
 * 2 输入头结点的值
 * 3 按照格式插入各个结点
 * 4 输入要删除的结点的值
 *
 * 输出描述:
 * 输出删除结点后的序列，每个数后都要加空格
 *
 * HJ48
 */
public class DeleteLinkedListValue {
    public static class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (null != (s = br.readLine())) {
            int n = Integer.parseInt(s);
            Node headNode = new Node(Integer.parseInt(br.readLine()));
            for (int i = 1; i < n; i++) {
                String[] str = br.readLine().split(" ");
                int pre = Integer.parseInt(str[1]);
                int nxt = Integer.parseInt(str[0]);
                Node node = headNode;
                while (node.val != pre){
                    node = node.next;
                }
                Node node1 = new Node(nxt);
                node1.next = node.next;
                node.next = node1;
            }

            int del = Integer.parseInt(br.readLine());
            StringBuilder ans = new StringBuilder();
            Node temp = headNode;
            while (temp != null) {
                if (temp.val != del) {
                    ans.append(temp.val).append(" ");
                }
                temp = temp.next;
            }
            System.out.println(ans.toString());
        }
    }
}
