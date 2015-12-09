public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int numsLen = nums.length;
        int[] result = new int[numsLen];
        
        if (numsLen == 0) {
            return result;
        }
        
        if (numsLen == 1) {
            result[0] = 1;
            return result;
        }
        
        int[] leftPass = new int[numsLen];
        int[] rightPass = new int[numsLen];
        
        leftPass[0] = nums[0];
        
        for (int i = 1; i < numsLen; i++) {
            leftPass[i] = nums[i] * leftPass[i-1];
        }
        
        rightPass[numsLen-1] = nums[numsLen-1];
        
        for (int i = numsLen-2; i > 0; i--) {
            rightPass[i] = nums[i] * rightPass[i+1];
        }
        
        for (int i = 0; i < numsLen; i++) {
            if (i == 0) {
                result[i] = rightPass[i+1];
            } else if (i == numsLen - 1) {
                result[i] = leftPass[i-1];
            } else {
                result[i] = rightPass[i+1] * leftPass[i-1];
            }
        }
        
        return result;
    }
}
