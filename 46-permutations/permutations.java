class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        int n = nums.length;
        Boolean[] used= new Boolean[n];
        backtrack(nums,used,new ArrayList<>(),result);
        return result;
    }
    public void backtrack(int[] nums, Boolean[] used, List<Integer> current, List<List<Integer>> result)
    {
        if(current.size()==nums.length)
        {
            result.add(new ArrayList(current));
            return;
        }
        for(int i=0; i<nums.length; i++)
        {
            if(used[i]==null || used[i]==false)
            {
                used[i]=true;
                current.add(nums[i]);
                backtrack(nums,used,current,result);
                current.remove(current.size()-1);
                used[i]=false;
            }
        }
    }
}