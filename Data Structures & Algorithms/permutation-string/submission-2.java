class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int i = 0;

        HashMap<Character, Integer> perm = new HashMap<>();

        for (char c : s1.toCharArray()) {
            perm.put(c, perm.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> curr = new HashMap<>();

        while (i < s2.length()) {
            char c = s2.charAt(i);

            if (i < s1.length()) {
                curr.put(c, curr.getOrDefault(c, 0) + 1);
                i++;
                continue;
            }

            int count = 0;
            for (char c2 : s1.toCharArray()) {
                if (curr.get(c2) == perm.get(c2)) {
                    count++;
                }
            }

            if (count == s1.length() ){
                return true;
            }


            char p = s2.charAt(i-s1.length());
        
            curr.put(p, curr.getOrDefault(p, 1) - 1);
            curr.put(c, curr.getOrDefault(c, 0) + 1);

            i++;
        }

        System.out.println(curr + " " + perm);

        int count = 0;
        for (char c2 : s1.toCharArray()) {
            if (curr.get(c2) == perm.get(c2)) {
                count++;
            }
        }

        if (count == s1.length() ){
            return true;
        }


        return false;
    }
}
