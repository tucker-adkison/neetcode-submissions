class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 

            // System.out.println(left + " " + star + " " + c);

            if (c == ')') {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            } else if (c == '*') {
                star.push(i);
            } else {
                left.push(i);
            }
        }

        while(!left.isEmpty() && !star.isEmpty()) {
            if (left.pop() > star.pop()) {
                return false;
            }
        }

        return left.isEmpty();
    }
}
