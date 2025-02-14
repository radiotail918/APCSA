import com.sun.jdi.Value;

import java.util.Arrays;
public class Deck {
    private Card[] cards;
    public static final int NUM_CARDS=52;
    public Deck()
    {
        cards= new Card[NUM_CARDS];
        for(int i =0 ; i<cards.length;i++)
        {
            int vaIndex=i%Card.VALUES.length;
            int suitIndex=i/Card.VALUES.length;
            cards[i]=new Card(suitIndex, vaIndex);
        }
    }
    public String toString()
    {
        String builder = "";
        for(int i=0;i<cards.length;i++)
        {
            builder+=cards[i]+"\t";
            if((i+1)%Card.VALUES.length==0)
            {
                builder+="\n";
            }

        }
        return builder;
    }
    public static void main(String[] args)
    {
        Deck d =new Deck();
        d.shuffle();
        System.out.println(Arrays.toString(d.cards));
    }
    public  void shuffle()
    {
        for(int i=0;i<cards.length;i++)
        {
            swap(i,(int)((Math.random())*cards.length));
        }

    }
    public void swap(int i , int j )
    {
        Card temp=cards[i];
        cards[i]=cards[j];
        cards[j]=temp;
}
}
