public class Card {
    private char suit;
    private String value;
    public static final char[] SUITS ={'\u2663' , '\u2661','\u2662','\u2660'};
    public static final String[] VALUES=
            {"A","1","2","3","4","5","6","7","8","9","10","J","Q","K"};
    public Card(int suitIndex, int ValueIndex)
    {
        suit=SUITS[suitIndex];
        value=VALUES[ValueIndex];

    }

    @Override
    public String toString() {
        return value+suit;
    }
    public static void main(String[] args)
    {
        Card c= new Card(3,12);
        System.out.println(c);
    }
}
