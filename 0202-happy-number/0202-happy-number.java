import java.util.HashMap;

class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        while (n != 1 && !map.containsKey(n)) {
            map.put(n, 1); 
            int s = sum(n);
            n = s; 
        }
        return n == 1;
    }

    public int sum(int n) {
        String s = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int num = ch - '0';
            sum += Math.pow(num, 2);
        }
        return sum;
    }
}
