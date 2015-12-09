public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        
        int len = nums.length;
        
        if (len == 1) {
            return 0;
        }
        
        for (int i=0; i < len; i++) {
            int leftVal = Integer.MIN_VALUE;
            int rightVal = Integer.MIN_VALUE;
            if (i != 0) {
                leftVal = nums[i-1];
            }
            if (i != len - 1) {
                rightVal = nums[i+1];
            }
            if (nums[i] > leftVal && nums[i] > rightVal) {
                return i;
            }
        }
        
        return -1;
    }
}
