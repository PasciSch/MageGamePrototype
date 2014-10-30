package magegameprototype;

import java.util.List;

public class AttackBehaviour extends Behaviour
{
    public AttackBehaviour(Element element, int attack)
    {
        this.setElement(element);
        this.setAttack(attack);
    }
    
    public void deploy(List<IBehaviour> ownBehaviours, List<IBehaviour> opposingBehaviours, IPlayer ownPlayer, IPlayer opposingPlayer)
    {
        for(IBehaviour behaviour : opposingBehaviours)
        {
            behaviour.act(ownBehaviours, opposingBehaviours, ownPlayer, opposingPlayer);
            if(this.isFinished())
            {
                break;
            }
            
            int opposingShield = behaviour.getShield();
            behaviour.setShield(opposingShield - this.getAttack());
            this.setAttack(this.getAttack() - opposingShield);
            
            if(this.getAttack() <= 0)
            {
                this.destroy();
                break;
            }
        }
        
        if (!this.isFinished())
        {
            int newHealth = opposingPlayer.getHealth() - this.getAttack();
            opposingPlayer.setHealth(newHealth);
        }
        
        this.destroy();
    }

    public void act(List<IBehaviour> ownBehaviours, List<IBehaviour> opposingBehaviours, IPlayer ownPlayer, IPlayer opposingPlayer)
    {
    }
}
