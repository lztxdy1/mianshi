package huawei.middle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class LRUCache {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    public void aVoid(String[] args) {
        //[[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> lessUse = new ArrayList<>();

        int k = 3;
        int[][] operations = {{1,1,1},{1,2,2},{1,3,2},{1,4,4},{2,2}};
        for (int i = 0; i < operations.length; i++) {
            if (operations[i][0] == 1 && hashMap.size() <= k){
                set(operations[i][1], operations[i][2]);
                lessUse.add(i);
            }
            else if (operations[i][0] == 2){
                result.add(get(operations[i][1]));
                lessUse.add(i);
            }
            else{
                hashMap.remove(lessUse.indexOf(0));
                lessUse.remove(0);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result);
        }


    }

    public void set(int key, int value){
        hashMap.put(key, value);
    }

    public int get(int key){
        if (hashMap.containsKey(key)){
            return key;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
