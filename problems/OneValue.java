import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Integer;
 
class OneValue {
 
    public static void main(String args[] ) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        List<Integer> values = new ArrayList<Integer>(), count = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(tk.nextToken());
            if (type == 1) {
                int val = Integer.parseInt(tk.nextToken());
                add_to_list(values, count, val);
            }
            else if (type == 2) {
                int val = Integer.parseInt(tk.nextToken());
                remove_from_list(values, count, val);
            }
            else if (type == 3) {
                int ans = find_least_frequency(values, count);
                System.out.println(ans);
            }
            else if (type == 4){
                int ans = find_highest_frequency(values, count);
                System.out.println(ans);
            }
        }
    }
    
    public static void add_to_list(List<Integer> values, List<Integer> count, int val){
        int idx = values.indexOf((Integer)val);
        if(idx == -1) {
            values.add(0, val);
            count.add(0, 1);
        }
        else {
            int newCnt = count.get(idx) + 1;
            int swapIdx = idx;
            while(swapIdx < count.size() && count.get(swapIdx) < newCnt) {
                swapIdx++;
            }
            if(swapIdx == count.size()) {
                swapIdx--;
            }
            while(idx < swapIdx) {
                values.set(idx, values.get(idx+1));
                count.set(idx, count.get(idx+1));
                idx++;
            }
            values.set(swapIdx, val);
            count.set(swapIdx, newCnt);
        }
    }
 
    public static void remove_from_list(List<Integer> values, List<Integer> count, int val){
        int idx = values.indexOf(val);
        if(idx != -1) {
            if(count.get(idx) == 1) {
                values.remove(idx);
                count.remove(idx);
            }
            else {
                int newCnt = count.get(idx) - 1;
                int swapIdx = idx;
                while(swapIdx >= 0 && count.get(swapIdx) > newCnt) {
                    swapIdx--;
                }
                if(swapIdx < 0) {
                    swapIdx++;
                }
                while(idx > swapIdx) {
                    values.set(idx, values.get(idx-1));
                    count.set(idx, count.get(idx-1));
                    idx--;
                }
                values.set(swapIdx, val);
                count.set(swapIdx, newCnt);
            }
        }
    }
 
    public static int find_least_frequency(List<Integer> values, List<Integer> count){
        if(values.isEmpty() == true) {
            return -1;
        }
        int idx = 0;
        int cnt = count.get(0), val = values.get(0);
        while(idx < count.size() && count.get(idx) == cnt) {
            if(val < values.get(idx)) {
                val = values.get(idx);
            }
            idx++;
        }
        return val;
    }
 
    public static int find_highest_frequency(List<Integer> values, List<Integer> count){
        if(values.isEmpty() == true) {
            return -1;
        }
        int idx = count.size() - 1;
        int cnt = count.get(idx), val = values.get(idx);
        while(idx >= 0 && count.get(idx) == cnt) {
            if(val > values.get(idx)) {
                val = values.get(idx);
            }
            idx--;
        }
        return val;
    }
}