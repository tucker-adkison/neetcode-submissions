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
        String digits = "";

        while(i < chArr.length) {
            if (Character.isDigit(chArr[i]) && chArr[i+1] == '#') {
                digits += chArr[i];
                
                int num =  Integer.parseInt(digits);

                i += 2;

                if (num == 0) {
                    result.add("");
                    continue;
                }

                String temp = "";

                for(int j = 0; j < num; j++) {
                    temp += chArr[i];
                    i++;
                }

                result.add(temp);
                digits = "";
            } else if (Character.isDigit(chArr[i]) && Character.isDigit(chArr[i+1])) {
                digits += chArr[i];
                i++;
            }
        }

        return result;
    }
}
