package magegameprototype;

public class MainLane extends Lane {

    public MainLane(IPlayer playerOne, IPlayer playerTwo)
    {
        super(playerOne, playerTwo);
    }
    
    @Override
    protected void behaviourAdded(IBehaviour behaviour)
    {
        behaviour.setVisible();
    }
}
