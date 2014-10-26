package magegameprototype;

import java.util.List;

public interface IPlayer
{
    List<ICard> getCards();
    
    int getHealth();
    
    void setHealth(int health);
}