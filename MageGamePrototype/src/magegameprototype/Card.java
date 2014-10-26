package magegameprototype;

public class Card implements ICard 
{
    private int durability;
    private int cost;
    private boolean used;

    public Card(int durability, int cost, boolean used)
    {
        this.durability = durability;
        this.cost = cost;
        this.used = used;
    }
    
    @Override
    public boolean isUsed()
    {
        return used;
    }

    @Override
    public void setUsed(boolean used)
    {
        this.used = used;
    }

    @Override
    public int getCost()
    {
        return cost;
    }

    @Override
    public void setCost(int cost)
    {
        this.cost = cost;
    }

    @Override
    public int getDurability()
    {
        return durability;
    }

    @Override
    public void setDurability(int durability)
    {
        this.durability = durability;
    }
}
