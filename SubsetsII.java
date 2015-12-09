public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for (int i=0; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for (int j=0; j < result.size(); j++) {
                temp.add(new ArrayList<Integer>(result.get(j)));
            }
            
            int current = nums[i];
            
            ArrayList<Integer> singleElement = new ArrayList<Integer>();
            singleElement.add(current);
            if (!result.contains(singleElement)) {
                result.add(singleElement);
            }
            
            for (int k=0; k < temp.size(); k++) {
                List<Integer> tempBit = temp.get(k);
                tempBit.add(current);
                if (!result.contains(tempBit)) {
                    result.add(tempBit);
                }
            }
        }
        
        //add empty set
	    result.add(0, new ArrayList<Integer>());
        
        return result;
    }
}
