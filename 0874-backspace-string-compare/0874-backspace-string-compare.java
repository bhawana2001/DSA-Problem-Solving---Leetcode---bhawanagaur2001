class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder ss=new StringBuilder();
        StringBuilder ts=new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#' && ss.length() > 0) {
                ss.deleteCharAt(ss.length() - 1);
            } else if (c != '#') {
                ss.append(c);
            }
        }

        for (char c : t.toCharArray()) {
            if (c == '#' && ts.length() > 0) {
                ts.deleteCharAt(ts.length() - 1);
            } else if (c != '#') {
                ts.append(c);
            }
        }

        return ss.toString().equals(ts.toString());

    }
}