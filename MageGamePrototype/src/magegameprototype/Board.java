package magegameprototype;

public class Board 
{
    private Lane mainLane;
    private Lane sideLaneLeft;
    private Lane sideLaneRight;
    private IPlayer playerOne;
    private IPlayer playerTwo;
    private CardRepository cardRepository;
    
    public Board(IPlayer playerOne, IPlayer playerTwo, CardRepository cardRepository)
    {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.cardRepository = cardRepository;
        
        this.mainLane = new MainLane(playerOne, playerTwo);
        this.sideLaneLeft = new SideLane(playerOne, playerTwo);
        this.sideLaneRight = new SideLane(playerOne, playerTwo);
    }
}
