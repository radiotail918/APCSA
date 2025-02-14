import java.util.Arrays;
import java.util.Scanner;
public class RPSGame {
    public static void main(String[] args)
    {
        Player robot= new Player();

        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your first name");
        String firstName=sc.next();
        System.out.println("Please enter your first name");
        String lastName=sc.next();
        Player player=new Player(firstName,lastName);
        String playAgain="Y";
        System.out.println("Please input your money");
        int money = sc.nextInt();
        player.setCash(money);
        robot.setCash(money);
        while(playAgain.equals("Y")) {

            System.out.println("Please set your bet");
            int bet = sc.nextInt();
            player.setBet(bet);
            robot.setBet(bet);
            while (bet > player.getCashOnHand() || bet > robot.getCashOnHand()) {
                System.out.println("not enough money to bet");
                System.out.println("Please set your bet");
                bet = sc.nextInt();
                player.setBet(bet);
                robot.setBet(bet);
            }
            System.out.println("Choose your weapon, 1 for rock, 2 for paper, 3 for scissors");
            int userChoice = sc.nextInt();
            while (!(userChoice == 1 || userChoice == 2 || userChoice == 3)) {
                System.out.println("not valid");
                System.out.println("Choose your weapon, 1 for rock, 2 for paper, 3 for scissors");
                userChoice = sc.nextInt();
            }
            player.setWeapon(userChoice);
            robot.setWeapon();

            if (player.getWeapon() == robot.getWeapon()) {
                System.out.println("Fair! Robot choose:" + robot.getWeaponstring() + " You choose: " + player.getWeaponstring());
            } else if (player.getWeapon() > robot.getWeapon()) {
                if (player.getWeapon() == 3 && robot.getWeapon() == 1) {
                    robot.win();
                    player.lose();
                    System.out.println("Robot win! Robot choose: " + robot.getWeaponstring() + " You choose: " + player.getWeaponstring());
                } else {
                    player.win();
                    robot.lose();
                    System.out.println("You win! Robot choose: " + robot.getWeaponstring() + " You choose: " + player.getWeaponstring());
                }
            } else if (robot.getWeapon() > player.getWeapon()) {
                if (robot.getWeapon() == 3 && player.getWeapon() == 1) {
                    player.win();
                    robot.lose();
                    System.out.println("you win! Robot choose: " + robot.getWeaponstring() + " You choose: " + player.getWeaponstring());
                } else {
                    robot.win();
                    player.lose();
                    System.out.println("robot win! Robot choose: " + robot.getWeaponstring() + " You choose: " + player.getWeaponstring());
                }
            }
            System.out.println(player);
            System.out.println(robot);
            System.out.println("Do you want to play again?(y/n)");
            playAgain=sc.next();
            playAgain=playAgain.toUpperCase();


        }
        Player[] players ={player, robot};
        Arrays.sort(players);
        System.out.println(Arrays.toString(players));
    }
}
