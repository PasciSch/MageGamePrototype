package magegameprototype;

import java.util.ArrayList;
import java.util.List;

public class Player implements IPlayer
{
    private static final int STARTHEALTH = 20;
    
    private int health;
    private List<ICard> cards;

    public Player()
    {
        this.health = STARTHEALTH;
        this.cards = new ArrayList<>();
    }
    
    @Override
    public List<ICard> getCards()
    {
        return cards;
    }

    @Override
    public int getHealth()
    {
        return health;
    }

    @Override
    public void setHealth(int health)
    {
        this.health = health;
    }
}
