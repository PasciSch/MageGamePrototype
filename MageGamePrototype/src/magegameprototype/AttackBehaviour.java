package magegameprototype;

import java.util.List;

public class AttackBehaviour extends Behaviour
{
    public AttackBehaviour(Element element, int attack)
    {
        this.setElement(element);
        this.setAttack(attack);
    }
    
    public void act(List<IBehaviour> ownBehaviours, List<IBehaviour> opposingBehaviours, IPlayer ownPlayer, IPlayer opposingPlayer)
    {
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
            
            this.AttackBehaviour(behaviour);
            
            if(this.getAttack() <= 0)
            {
                this.destroy();
                break;
            }
        }
        
        if (!this.isFinished())
        {
            AttackPlayer(opposingPlayer);
        }
        
        this.destroy();
    }

    private void AttackPlayer(IPlayer opposingPlayer)
    {
        int newHealth = opposingPlayer.getHealth() - this.getAttack();
        opposingPlayer.setHealth(newHealth);
    }

    private void AttackBehaviour(IBehaviour behaviour)
    {
        float adaptedShield = this.getAdaptedShield(behaviour);
        float damagedAdaptedShield = adaptedShield - this.getAttack();
        this.setAttack((int) (this.getAttack() - adaptedShield));
        float realShield = this.getRealShield(damagedAdaptedShield, behaviour.getElement());
        behaviour.setShield((int) realShield);
    }

    private float getAdaptedShield(IBehaviour behaviour)
    {
        float adaptedShield = behaviour.getShield();
        
        Element shieldElement = behaviour.getElement();
        if (shieldElement.isSuperiorTo(this.getElement()))
        {
            adaptedShield = adaptedShield * 2;
        }
        
        if (shieldElement.isInferiorTo(this.getElement()))
        {
            adaptedShield = adaptedShield / 2;
        }
        
        return adaptedShield;
        
    }

    private float getRealShield(float adaptedShield, Element shieldElement)
    {
        if (shieldElement.isSuperiorTo(this.getElement()))
        {
            adaptedShield = adaptedShield / 2;
        }
        
        if (shieldElement.isInferiorTo(this.getElement()))
        {
            adaptedShield = adaptedShield * 2;
        }
        
        return adaptedShield;
    }
}
