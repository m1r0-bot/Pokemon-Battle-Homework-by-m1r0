package battle;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Battle {
    
    
    static Character character = new Character();
    static Battle battle = new Battle();
    static opponents foe = new opponents();
    static Random rng = new Random();
    static int attacks[][] = {{10,80},
                              {70,20},
                              {40,40},
                              {0,100}};
    static int hp = character.getHp();
    static int ehp = foe.mouse[1];
    static int stunDuration = 0;
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws InterruptedException 
    {      
        
        
        
        
        battle.Write("Enter your name:");
        String your_name = scanner.nextLine();
        battle.Write("Hi " + your_name + ", by the way, you are cat. You see small mouse and you must beat it!!");
        
        scanner.nextLine();
        
        
        for(int enemy = 0; enemy <= 2; enemy++)
        {     
            ehp = foe.getHp(enemy);
            boolean fight = true;
            while(fight == true)
            {

            character.drawHpBar(foe.getEnemy(enemy),foe.getMaxHp(enemy),ehp);
            character.drawHpBar(your_name,character.getfullHp(),hp);
            
            System.out.println();
            
            System.out.println("Your attacks:");
            battle.AttackName(1, "Scratch",    "easy to hit but deal small damage   ", attacks[0][0], attacks[0][1]);
            battle.AttackName(2, "Bite",       "deal heavy hit, but it's hard to hit", attacks[1][0], attacks[1][1]);
            battle.AttackName(3, "Tale Swipe", "medium accuracy and medium damage   ", attacks[2][0], attacks[2][1]);
            battle.AttackName(4, "Sonic Mew",  "chance to stun your enemy | no dmg  ", attacks[3][0], attacks[3][1]);
            
            //chose your attack
            System.out.println("Choose your attack");
            int choise = 0;
            for(boolean wrongAttack = true;wrongAttack == true;)
            {
                choise = scanner.nextInt() - 1;
                if(choise < 4 && choise >= 0)
                    wrongAttack = false;
                else System.out.println("please enter correct number (1, 2, 3 or 4). try it again XD");
            }

            //calculate that atack 60*80 /100     10 * 60 \ 100
            battle.Attack(choise, enemy);

            if (ehp <= 0)
                {
                    battle.Write("You have won against this dangerouse foe");
                    fight = false;
                    scanner.nextLine();
                } 
            else
            battle.eAttack(rng.nextInt(3), enemy);
                if(hp <= 0)
                {
                    battle.Write("You have lost your fight to this terrible foe");
                    fight = false;
                    scanner.nextLine();
                }

            }
            if(enemy < 2)
            {
                battle.Write("You have been healed for 10 hp");
                hp += 10;
                scanner.nextLine();
                battle.Write("Your next enemy is " + foe.getEnemy(enemy + 1));
                scanner.nextLine();
            }
            else
            {
                battle.Write("You have destroyed the enemy dog and now you are the Most Powerful Cat");
            }
        }
        
    }
    
    public void eAttack(int x, int f)
    {
        if(stunDuration != 0)
        {
            stunDuration -= 1;
            System.out.println("Enemy is stunned and can't attack");
            
            if(stunDuration ==0)
            {
                System.out.println("Next turn enemy will attack again");
                
            }
            scanner.nextLine();
        }
        else
        {
            int hitPercent = attacks[x][1] * foe.getspeed(f) / 100;
            if (hitPercent >= rng.nextInt(character.getSpeed()))
            {
                hp -= attacks[x][0] * foe.getAttack(f) /100;
                System.out.println("enemy have hitted you for " + attacks[x][0] * foe.getAttack(f) / 100 + " hp");
                scanner.nextLine();

            }
            else 
            {
                System.out.println("Enemy have missed his attack");
                scanner.nextLine();
            }
        }
    }
    
    public void Attack(int x, int f)
    {
        
        
        int hitPercent = attacks[x][1] * character.getSpeed() / 100;
        if (hitPercent >= rng.nextInt(foe.getspeed(f)))
        {
            if (x == 3)
            {
                System.out.println("You have stunned your enemy");
                scanner.nextLine();
                stunDuration = 2;
            }
            else
            {
                ehp -= attacks[x][0] * character.getAttack() / 100;
                System.out.println("you have hit your enemy for " + attacks[x][0] * character.getAttack() / 100 + " hp");
                scanner.nextLine();
            }
        }
        else 
        {
            System.out.println("You have missed your attack");
            scanner.nextLine();
        }       
    }
    
    
    public void Write(String write) throws InterruptedException 
    {        
        for(int i = 0; i < write.length(); i++)
        {
            System.out.print(write.charAt(i));
            Thread.sleep(0);
        } 
        System.out.println();
    }
    public void AttackName(int number, String name, String text, int strenght,int accuracy)
    {
        System.out.println(number + ": " +name);
        System.out.println("      " + text + "     d/a = " + strenght +"/"+ accuracy);
        System.out.println("________________________________________________________________");
    }
    
}
