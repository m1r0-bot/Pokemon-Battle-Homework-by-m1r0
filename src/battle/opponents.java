package battle;
public class opponents 
{
    
                        
                        //maxhp,hp,att,speed
    public int [] mouse = {30, 30, 10, 100};
    public int [] cat   = {60, 60, 30, 50};
    public int [] dog   = {100,100,50, 30};
    
    public int getMaxHp(int x)
    {
        if      (x == 0) return mouse[0];
        else if (x == 1) return cat[0];
        else             return dog[0];
    }
    public int getHp(int x)
    {
        if      (x == 0) return mouse[1];
        else if (x == 1) return cat[1];
        else             return dog[1];
    }
    public int getAttack(int x)
    {
        if      (x == 0) return mouse[2];
        else if (x == 1) return cat[2];
        else             return dog[2];
    }
    public int getspeed(int x)
    {
        if      (x == 0) return mouse[3];
        else if (x == 1) return cat[3];
        else             return dog[3];
    }
    public String getEnemy(int x)
    {
        if      (x == 0) return "Mouse";
        else if (x == 1) return "Cat";
        else             return "Dog";
    }
}
