class Solution {
    public int lengthOfLongestSubstring(String s) {
        String nonRepeat="";
        int count=0;
        for(int i=0;i<=s.length();i++)
        {
            nonRepeat+=s.charAt(i);
            if(s.contains(nonRepeat))
            {
                count++;

            }
            return count;

        }


    }
}