package magegameprototype;

import java.util.List;

public class ShieldBehaviour extends Behaviour
{
    public ShieldBehaviour(Element element, int shield)
    {
        this.setElement(element);
        this.setShield(shield);
    }
    
    @Override
    public void deploy(List<IBehaviour> ownBehaviours, List<IBehaviour> opposingBehaviours, IPlayer ownPlayer, IPlayer opposingPlayer)
    {
    }

    @Override
    public void act(List<IBehaviour> ownBehaviours, List<IBehaviour> opposingBehaviours, IPlayer ownPlayer, IPlayer opposingPlayer)
    {
    }
}
