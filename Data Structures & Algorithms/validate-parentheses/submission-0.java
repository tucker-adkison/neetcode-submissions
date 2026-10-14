class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c == ')' && stack.pop() == '(') {
                continue;
            } else if (c == ']' && stack.pop() == '[') {
                continue;
            } else if (c == '}' && stack.pop() == '{') {
                continue;
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
