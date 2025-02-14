public class ManyDeck {
    private int numDecks;
    private Deck[] decks;
    public ManyDeck(int numDecks)
    {
        this.numDecks=numDecks;
        decks=new Deck[this.numDecks];
        for(int i=0;i<decks.length;i++)
        {
            decks[i]=new Deck();
        }

    }
    public String toString()
    {
        String builder="";
        for(Deck d:decks)
        {
            builder+=d+"\n";

        }
        return builder;
    }
    public void shuffleAll()
    {
        for(Deck d:decks){
            d.shuffle();
        }
    }
    public static void main(String[] args)
    {
        ManyDeck m=new ManyDeck(3);
        System.out.println(m);
    }
}
