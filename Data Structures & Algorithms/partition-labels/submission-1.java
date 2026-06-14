class Solution {
    public List<Integer> partitionLabels(String s) {
        ArrayList<String> substrings = new ArrayList<>();
        HashMap<Character, Integer> pos = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            if (pos.containsKey(c)) {
                int index = pos.get(c);

                // merge
                if (substrings.size() > 1) {
                    int i = substrings.size() - 1;
                    int mergeTo = substrings.size() - 1;
                    while (i > index) {
                        substrings.set(i-1, substrings.get(i-1) + substrings.get(i));
                        substrings.remove(i);
                        i--;
                    }

                    for (char c2 : substrings.get(index).toCharArray()) {
                        pos.put(c2, index);
                    }
                }

                substrings.set(substrings.size() - 1, substrings.get(substrings.size() - 1) + c);
            } else {
                // add the substring to the list as a single char and index
                substrings.add(c + "");
                pos.put(c, substrings.size() - 1);
            }
        }

        System.out.println(substrings);

        return substrings.stream().map(str -> str.length()).collect(Collectors.toList());
    }
}
