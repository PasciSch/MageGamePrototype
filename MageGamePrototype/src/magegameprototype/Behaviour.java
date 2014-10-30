package magegameprototype;

public abstract class Behaviour implements IBehaviour
{
    private Element element;
    private int shield;
    private int attack;
    private boolean isFinished;
    private boolean isVisible;

    public Behaviour()
    {
        this.element = Element.Neutral;
        this.shield = 0;
        this.attack = 0;
        this.isFinished = false;
        this.isVisible = false;
    }
    
    @Override
    public Element getElement()
    {
        return this.element;
    }

    @Override
    public void setElement(Element element)
    {
        this.element = element;
    }

    @Override
    public int getShield()
    {
        return this.shield;
    }

    @Override
    public void setShield(int shield)
    {
        if(this.shield != 0 && shield <= 0)
        {
            this.destroy();
        }
        
        this.shield = shield;
    }

    @Override
    public int getAttack()
    {
        return this.attack;
    }

    @Override
    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    @Override
    public boolean isFinished()
    {
        return this.isFinished;
    }

    @Override
    public void destroy()
    {
        this.isFinished = true;
    }

    @Override
    public boolean isVisible()
    {
        return this.isVisible;
    }

    @Override
    public void setVisible()
    {
        this.isVisible = true;
    }
}
