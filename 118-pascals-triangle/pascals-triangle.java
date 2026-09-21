class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> last = new ArrayList<>();       // Base List
        last.add(1);
        res.add(last);

        for(int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(last.get(0));

            for(int j = 1; j < last.size(); j++) {
                temp.add(last.get(j - 1) + last.get(j));
            }

            temp.add(last.get(last.size() - 1));
            res.add(temp);
            last = temp;
        }

        return res;
    }
}