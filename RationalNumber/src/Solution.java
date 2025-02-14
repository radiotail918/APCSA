class Solution {
    public boolean isValid(String s) {
        int count=0;
        boolean result = false;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)==')'||s.charAt(i)=='{'||s.charAt(i)=='}'||s.charAt(i)=='['||s.charAt(i)==']')
            {
                count++;

            }
            else
            {
                result=false;
                break;
            }

            if(count==s.length())
            {
                result=true;
            }
        }
        return result;
    }
}