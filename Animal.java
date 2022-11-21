import java.time.LocalDateTime;

public class Animal implements Exhibitable<Exhibit>
{

    public static int numberAnimals;
    private int animalID;

    private String name;

    private LocalDateTime birthday;

    private boolean beingShown = false;

    public Animal()
    {
        beBorn();
        setName("unnamed");
    }

    public Animal(String name)
    {
        beBorn();
        setName(name);
    }

    public final void beBorn()
    {
        numberAnimals++;
        this.animalID = numberAnimals;
        this.birthday = LocalDateTime.now();
    }

    public String getName()
    {
        return name;
    }

    private void setName(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return String.format("Animal ID #%d\n, Name: %s", animalID, name);
    }

    public void releaseInto(Exhibit exhibit)
    {
        exhibit.showAnimal(this);
        beingShown = true;
    }

    public void removeFrom(Exhibit exhibit)
    {
        exhibit.removeAnimal(this);
        beingShown = false;
    }

    public void exhibitMe(Exhibit exhibit)
    {
        releaseInto(exhibit);
        removeFrom(exhibit);
    }

    public static void main(String[] args)
    {
    }
}
