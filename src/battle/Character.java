package battle;

public class Character {
    
    private int fullhp = 100;
    private int hp = 50;  
    private int attack = 60;
    private int speed = 60; 
   
    public int getHp()
    {
        return hp;
    }    
    public void setHp(int hp)
    {
        this.hp = hp;
    }
    public int getfullHp()
    {
        return fullhp;
    }    
    public void setfullHp(int hp)
    {
        this.fullhp = hp;
    }
    public int getAttack()
    {
        return attack;
    }    
    public void setAttack(int attack)
    {
        this.attack = attack;
    }
    public int getSpeed()
    {
        return speed;
    }    
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    
    
    public void drawHpBar(String name, int fullhp, int hp)
    {
        System.out.println("_______________________________________________");
        System.out.print("|| " + name + "'s HP: ");
        for(int i = 0; i < fullhp;i += 10)
        {
            if (i < hp)
                System.out.print("█ ");
            else
                System.out.print("▒ ");
        }
        System.out.println("||");
        System.out.println("_______________________________________________");
    }
}