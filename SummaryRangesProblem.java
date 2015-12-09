public class SummaryRangesProblem {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> result = new ArrayList<String>();
        int numsLen = nums.length;
        
        if (numsLen == 0) {
            return result;
        }
        
        int startIndex = 0;
        for (int i=0 ; i < numsLen - 1 ; i++) {
            if (nums[i+1] != nums[i] + 1) {
                if (i == startIndex) {
                    result.add(nums[startIndex] + "");
                } else {
                    result.add(nums[startIndex] + "->" + nums[i]);
                }
                startIndex = i+1;
            }
        }
        
        if (startIndex == numsLen - 1) {
            result.add(nums[startIndex] + "");
        } else {
            result.add(nums[startIndex] + "->" + nums[nums.length-1]);
        }
        return result;
    }
}
