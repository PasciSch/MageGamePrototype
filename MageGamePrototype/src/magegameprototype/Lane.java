package magegameprototype;

import java.util.ArrayList;
import java.util.List;

public abstract class Lane 
{
    private List<IBehaviour> sideOne;

    public List<IBehaviour> getSideOne()
    {
        return sideOne;
    }

    public List<IBehaviour> getSideTwo()
    {
        return sideTwo;
    }
    private List<IBehaviour> sideTwo;
    private final IPlayer playerOne;
    private final IPlayer playerTwo;

    public Lane(IPlayer playerOne, IPlayer playerTwo)
    {
        this.sideOne = new ArrayList<>();
        this.sideTwo = new ArrayList<>();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }
    
    public void addToSideOne(IBehaviour behaviour)
    {
        this.behaviourAdded(behaviour);
        this.sideOne.add(behaviour);
        behaviour.deploy(this.sideOne, this.sideTwo, this.playerOne, this.playerTwo);
        this.cleanUpLane();
    }
    
    public void addToSideTwo(IBehaviour behaviour)
    {
        this.behaviourAdded(behaviour);
        this.sideTwo.add(behaviour);
        behaviour.deploy(this.sideTwo, this.sideOne, this.playerTwo, this.playerOne);
        this.cleanUpLane();
    }

    private void cleanUpLane()
    {
        this.sideOne.removeIf(behaviour -> behaviour.isFinished());
        this.sideTwo.removeIf(behaviour -> behaviour.isFinished());
    }

    protected abstract void behaviourAdded(IBehaviour behaviour);
}
