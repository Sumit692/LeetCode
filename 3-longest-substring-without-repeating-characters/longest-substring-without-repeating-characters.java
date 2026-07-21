class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set <Character> charSet=new HashSet<>
();
int n =s.length();
int left=0,max_len=0;
for(int right=0;right<n;right++)
{
    while(charSet.contains(s.charAt(right)))
    {
        charSet.remove(s.charAt(left));
        left++;
    }
    charSet.add(s.charAt(right));
    max_len=Math.max(max_len,right-left+1);
}
return max_len ;
   }
}