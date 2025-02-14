public class Player implements Comparable<Player>{
    private String firstName;
    private String lastName;
    private int win;
    private int lose;
    private int cashOnHand;
    private int currentBetAmount;
    private Weapon currentChoice;

    public Player() {
        firstName = "George";
        lastName = "Devol";
        win = 0;
        lose=0;
        cashOnHand = 0;
        currentBetAmount = 0;
        currentChoice=new Weapon();

    }

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        win=0;
        lose=0;
        cashOnHand = 0;
        currentBetAmount = 0;
        currentChoice = new Weapon();

    }

    public void setCash(int cash) {
        cashOnHand = cash;
    }

    public void setBet(int bet) {
        currentBetAmount = bet;
    }

    public void win() {
        win +=1;
        cashOnHand += currentBetAmount;
        currentBetAmount = 0;
    }

    public void lose() {
        lose+=1;
        cashOnHand -= currentBetAmount;
        currentBetAmount = 0;
    }

    public void setWeapon() {
        currentChoice.setWeapon();

    }

    public void setWeapon(int givenNumber) {
        currentChoice.setWeapon(givenNumber);
    }

    public int getWeapon() {
        return currentChoice.getWeapon();
    }

    public int getCashOnHand() {
        return cashOnHand;

    }
    public String getWeaponstring()
    {
        if (currentChoice.getWeapon() == 1)
            return "rock";
        else if (currentChoice.getWeapon() == 2)
            return "paper";
        else
            return "scissors";
    }
    @Override
    public String toString() {
        return firstName+" "+lastName+". Current Cash:"+cashOnHand+". Wins:"+win+" Lose:"+lose+" Win percentage= "+getWinPercentage()+"%\n";
    }
    public double getWinPercentage()
    {
        int totalPlay=win+lose;
        if(totalPlay==0)
        {
            return -1;
        }
        else
            return (double)win/totalPlay*100;

    }
    @Override
    public int compareTo(Player other)
    {
        return Double.compare(other.getWinPercentage(),this.getWinPercentage());
    }

}
