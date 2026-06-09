class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int fp = 0;
        int sp = 1;
        int tp = 2;

        while (fp  < nums.length) {
            int num1 = nums[fp];
            
            if (num1 > 0) {
                break;
            }

            while (sp < nums.length) {
                int num2 = nums[sp];
                
                if (num1 + num2 > 0) {
                    break;
                }

                while (tp < nums.length) {
                    int num3 = nums[tp];

                    if (num1 + num2 + num3 > 0) {
                        break;
                    }

                    if (num1 + num2 + num3 == 0) {
                        ArrayList<Integer> temp = new ArrayList<>();

                        temp.add(num1);
                        temp.add(num2);
                        temp.add(num3);

                        result.add(temp);
                    }

                    if (num3 == nums[tp]) {
                        while (tp < nums.length && num3 == nums[tp]) {
                            tp++;
                        }
                        tp--;
                    }

                    tp++;
                }

                if (num2 == nums[sp]) {
                    while (sp < nums.length && num2 == nums[sp]) {
                        sp++;
                    }
                    sp--;
                }

                sp++;
                tp = sp + 1;
            }

           if (num1 == nums[fp]) {
                while (fp < nums.length && num1 == nums[fp]) {
                    fp++;
                }
                fp--;
            }

            fp++;
            sp = fp + 1;
            tp = sp + 1;
        }

        return result;
    }
}
