class Solution {
    public void backtrack(int[] nums, int start, int end, List<Integer> current, List<List<Integer>>result)
    {
        result.add(new ArrayList<>(current));
        for(int i=start;i<=end;i++)
        {
            current.add(nums[i]);
            backtrack(nums, i+1, end, current, result);
            current.remove(current.size()-1);
        }
    }
        public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<Integer> current=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums,0,n-1,current, result);
        return result;
    }
}