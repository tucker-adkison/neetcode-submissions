class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
        HashSet<Character> characters = new HashSet<>();

        if (words.length == 1) {
            return words[0];
        }
        
        for (int i = 0; i < words.length; i++) {
            String w1 = words[i];
            char[] charArr = w1.toCharArray();

            for (int j = 0; j < charArr.length; j++) {
                char first = w1.charAt(j);

                characters.add(first);
            }

            if (i + 1 < words.length) {
                String w2 = words[i+1];
                boolean foundDiff = false;

                for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                    char first = w1.charAt(j);
                    char second = w2.charAt(j);
                    if (first != second) {
                        if (graph.containsKey(first)) {
                            ArrayList<Character> chars = graph.get(first);
                            if (!chars.contains(second)) {
                                chars.add(second);
                            }
                        } else {
                            ArrayList<Character> chars = new ArrayList<>();
                            chars.add(second);
                            graph.put(first, chars);
                        }
                        foundDiff = true;
                        break;
                    }
                }
                
                if (!foundDiff && w1.length() > w2.length()) {
                    return "";
                }
            }      
        }

        String result = "";

        HashMap<Character, Integer> indegree = new HashMap<>();

        for (char c : characters) {
            if (graph.containsKey(c)) {
                for (char edge : graph.get(c)) {
                    if (indegree.containsKey(edge)) {
                        indegree.put(edge, indegree.get(edge) + 1);
                    } else {
                        indegree.put(edge, 1);
                    }
                }
            } 

            if (!indegree.containsKey(c)) {
                indegree.put(c, 0);
            }
        }

        Queue<Character> q = new LinkedList<>();
        
        for (char key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                q.add(key);
            }
        }

        while (!q.isEmpty())  {
            char curr = q.poll();
            result += curr;

            if (graph.containsKey(curr)) {
                for (char n : graph.get(curr)) {
                    if (indegree.get(n) - 1 == 0) {
                        q.add(n);    
                    }

                    indegree.put(n, indegree.get(n) -1);
                }
            }
        }

        return result.length() == characters.size() ? result : "";
    }
}
