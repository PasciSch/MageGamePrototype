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
        int adaptedShield = this.getAdaptedShield(behaviour);
        int damagedAdaptedShield = adaptedShield - this.getAttack();
        this.setAttack((int) (this.getAttack() - adaptedShield));
        float realShield = this.getRealShield(damagedAdaptedShield, behaviour.getElement());
        behaviour.setShield((int) realShield);
    }

    private int getAdaptedShield(IBehaviour behaviour)
    {
        int adaptedShield = behaviour.getShield();
        
        Element shieldElement = behaviour.getElement();
        if (shieldElement.isSuperiorTo(this.getElement()))
        {
            adaptedShield = adaptedShield * 2;
        }
        
        if (shieldElement.isInferiorTo(this.getElement()))
        {
            double decimalPlacesAdaptedShield = (float)adaptedShield / 2;
            adaptedShield = (int)Math.ceil(decimalPlacesAdaptedShield);
        }
        
        return adaptedShield;
        
    }

    private int getRealShield(int adaptedShield, Element shieldElement)
    {
        if (shieldElement.isSuperiorTo(this.getElement()))
        {
            double decimalPlacesAdaptedShield = (float)adaptedShield / 2;
            adaptedShield = (int)Math.ceil(decimalPlacesAdaptedShield);
        }
        
        if (shieldElement.isInferiorTo(this.getElement()))
        {
            adaptedShield = adaptedShield * 2;
        }
        
        return adaptedShield;
    }
}
