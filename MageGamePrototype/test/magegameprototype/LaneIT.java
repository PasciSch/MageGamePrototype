package magegameprototype;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LaneIT
{
    private static final int STARTHEALTH = 10;
    private IPlayer player1;
    private IPlayer player2;
    private Lane lane;

    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
        this.player1 = new Player();
        this.player1.setHealth(STARTHEALTH);
        this.player2 = new Player();
        this.player2.setHealth(STARTHEALTH);
        this.lane = new MainLane(player1, player2);
    }
    
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void Scenario1()
    {
        // Given 3 neutral shields each 2 defence
        // When  1 neutral attack of 5 is deployed
        // Then  1 shield with 1 defence stays
        
        this.lane.addToSideOne(new ShieldBehaviour(Element.Neutral, 2));
        this.lane.addToSideOne(new ShieldBehaviour(Element.Neutral, 2));
        this.lane.addToSideOne(new ShieldBehaviour(Element.Neutral, 2));

        this.lane.addToSideTwo(new AttackBehaviour(Element.Neutral, 5));
        
        Assert.assertEquals(1, this.lane.getSideOne().size());
        Assert.assertEquals(0, this.lane.getSideTwo().size());
        Assert.assertEquals(1, this.lane.getSideOne().get(0).getShield());
    }
    
    @Test
    public void SimpleNeutralAttackDefenceScenario1()
    {
        // Given 1 neutral shield with 2 defence
        // When  1 neutral attack of 5 is deployed
        // Then  0 shield stays
        // And   player takes 3 damage
        
        this.lane.addToSideOne(new ShieldBehaviour(Element.Neutral, 2));

        this.lane.addToSideTwo(new AttackBehaviour(Element.Neutral, 5));
        
        Assert.assertEquals(0, this.lane.getSideOne().size());
        Assert.assertEquals(0, this.lane.getSideTwo().size());
        Assert.assertEquals(STARTHEALTH - 3, this.player1.getHealth());
    }
    
    @Test
    public void SimpleNeutralAttackDefenceScenario2()
    {
        // Given 1 neutral shield with 3 defence
        // When  1 neutral attack of 3 is deployed
        // Then  0 shield stays
        // And   player takes 0 damage
        
        this.lane.addToSideOne(new ShieldBehaviour(Element.Neutral, 3));

        this.lane.addToSideTwo(new AttackBehaviour(Element.Neutral, 3));
        
        Assert.assertEquals(0, this.lane.getSideOne().size());
        Assert.assertEquals(0, this.lane.getSideTwo().size());
        Assert.assertEquals(STARTHEALTH, this.player1.getHealth());
    }
    
    @Test
    public void SimpleNeutralAttackDefenceScenario3()
    {
        // Given 1 neutral shield with 4 defence
        // When  1 neutral attack of 1 is deployed
        // Then  1 shield stays with 3 defence
        // And   player takes 0 damage
        
        this.lane.addToSideOne(new ShieldBehaviour(Element.Neutral, 4));

        this.lane.addToSideTwo(new AttackBehaviour(Element.Neutral, 1));
        
        Assert.assertEquals(1, this.lane.getSideOne().size());
        Assert.assertEquals(0, this.lane.getSideTwo().size());
        Assert.assertEquals(3, this.lane.getSideOne().get(0).getShield());
        Assert.assertEquals(STARTHEALTH, this.player1.getHealth());
    }
}