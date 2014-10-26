package magegameprototype;

public interface ICard
{
    int getCost();

    int getDurability();

    boolean isUsed();

    void setCost(int cost);

    void setDurability(int durability);

    void setUsed(boolean used);
}