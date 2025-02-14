public class HiddenWord {
    private String answer;
    private String returnLetter;
    public HiddenWord(String givenAnswer)
    {
        answer=givenAnswer;
        returnLetter="";

    }
    public String getHint(String inputLetter)
    {
        for(int i=0;i<inputLetter.length();i++)
        {
            if(inputLetter.charAt(i)==answer.charAt(i))
            {
                returnLetter+=inputLetter.charAt(i);
            }
            else if (answer.indexOf(inputLetter.charAt(i))!=-1) {
                {
                    returnLetter+="+";
                }
            }
            else {
                returnLetter+="*";
            }
        }
        return returnLetter;
    }


}