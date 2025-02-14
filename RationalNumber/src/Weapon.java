import java.util.Scanner;

public class Weapon
{
    private int weapon;

    public Weapon()
    {
        this.weapon = (int)((Math.random() * 3) + 1);
    }

    public Weapon(int weapon)
    {
        if (weapon == 1 || weapon == 2 || weapon == 3)
            this.weapon = weapon;
        else
            throw new IllegalArgumentException();
    }

    public int getWeapon()
    {
        return this.weapon;
    }

    public void setWeapon()
    {
        weapon = (int)((Math.random()* 3) + 1);
    }

    public void setWeapon(int weapon)
    {
        if (weapon == 1 || weapon == 2 || weapon == 3)
            this.weapon = weapon;
        else
            throw new IllegalArgumentException();
    }

    public String toString()
    {
        if (weapon == 1)
            return "rock";
        else if (weapon == 2)
            return "paper";
        else
            return "scissors";
    }

}