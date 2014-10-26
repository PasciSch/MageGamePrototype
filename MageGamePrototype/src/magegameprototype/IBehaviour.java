package magegameprototype;

import java.util.List;

public interface IBehaviour
{
    Element getElement();
    
    void setElement(Element element);
    
    int getShield();
    
    void setShield(int shield);
    
    int getAttack();
    
    void setAttack(int attack);
    
    void deploy(List<IBehaviour> ownBehaviours, List<IBehaviour> opposingBehaviours, IPlayer ownPlayer, IPlayer opposingPlayer);
    
    void act(List<IBehaviour> ownBehaviours, List<IBehaviour> opposingBehaviours, IPlayer ownPlayer, IPlayer opposingPlayer);
    
    boolean isFinished();
    
    void destroy();
    
    boolean isVisible();
    
    void setVisible();
}