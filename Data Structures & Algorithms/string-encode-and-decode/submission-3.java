class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append("#").append(str); // Adds a delimiter after each item
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();

        char[] chArr = str.toCharArray();
        int i = 0;
        int j = 0;

        while(i < chArr.length) {
            while(chArr[j] != '#') {
                j++;
            }

            int digits = Integer.parseInt(str.substring(i, j));

            result.add(str.substring(j+1, j+digits+1));
            i = j + digits+1;
            j = i;

            // break;
        }

        return result;
    }
}
