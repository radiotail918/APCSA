import java.util.Arrays;

public class PlayerTest
{
    public static void main(String[] args)
    {
        Player p1 = new Player();
        Player p2 = new Player("John", "Smith");
        Player p3 = new Player("Rita", "Barber");

        p1.setCash(100);
        p2.setCash(100);
        p3.setCash(100);
        p1.setBet(50);
        p1.win();
        p2.setBet(20);
        p2.lose();
        System.out.print(p1 + "\n");
        System.out.print(p2 + "\n");
        System.out.print(p3 + "\n\n");

        Player[] players = {p1, p2, p3};
        System.out.println(Arrays.toString(players));
        Arrays.sort(players);
        System.out.println("\n" + Arrays.toString(players));

        p2.setWeapon();
        System.out.println(p2.getWeapon());
        p1.setWeapon(2); //pass whatever data type your function accepts
        System.out.println(p1.getWeapon());

    }
}