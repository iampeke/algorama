public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int newMergedLen = len1 + len2;
        int[] mergedNums = new int[newMergedLen];
        
        // Merge two sorted arrays:
        int i=0;
        int j=0;
        for (int k=0; k < newMergedLen; k++) {
            if (i == len1) {
                mergedNums[k] = nums2[j];
                j++;
            } else if (j == len2) {
                mergedNums[k] = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                mergedNums[k] = nums1[i];
                i++;
            } else {
                mergedNums[k] = nums2[j];
                j++;
            }
        }
        
        if (newMergedLen == 1) {
            return mergedNums[0];
        }
        
        if (newMergedLen == 2) {
            return ((mergedNums[0] + mergedNums[1]) / 2.0);
        }
        
        // Grab middle element from merged array:
        int midIndex = newMergedLen / 2;
        if (newMergedLen % 2 == 0) {
            return ((mergedNums[midIndex] + mergedNums[midIndex-1]) / 2.0);
        } else {
            return mergedNums[midIndex] * 1.0;
        }
    }
}
