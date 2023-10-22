class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String ele : tokens) {
            if (Character.isDigit(ele.charAt(0)) || (ele.length() > 1 && ele.charAt(0) == '-')) {
                int val = Integer.parseInt(ele);
                st.push(val);
            } else {
                int val2 = st.pop();
                int val1 = st.pop();
                int ans = eval(val1, val2, ele.charAt(0));
                st.push(ans);
            }
        }
        return st.pop();
    }

    public int eval(int val1, int val2, char op) {
        if (op == '*') {
            return val1 * val2;
        } else if (op == '/') {
            return val1 / val2;
        } else if (op == '+') {
            return val1 + val2;
        } else {
            return val1 - val2;
        }
    }
}
