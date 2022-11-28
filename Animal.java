import java.util.ArrayList;
import java.time.LocalDateTime;

public class Animal implements Housable<Exhibit>
{

    public static ArrayList<Animal> animalLedger = new ArrayList<>();
    public static int numberAnimals;
    private int animalID;

    private String name;

    private LocalDateTime birthday;

    private boolean isAlive = false;
    private boolean beingShown = false;
    private boolean inEnclosure = true;

    public Animal()
    {
        this("unnamed");
    }

    public Animal(String name)
    {
        beBorn();
        setName(name);
    }

    public final void beBorn()
    {
        isAlive = true;
        animalLedger.add(this);
        numberAnimals++;
        this.animalID = numberAnimals;
        this.birthday = LocalDateTime.now();
    }

    public String getName()
    {
        return name;
    }

    public int getAnimalID()
    {
        return animalID;
    }

    private void setName(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return String.format(
                "Animal ID #%d\n, Name: %s\n",
                getAnimalID(),
                getName()
                );
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

    /*
    public void houseIn(Enclosure enclosure)
    {
    }

    // These next 2 methods could be overloaded. But maybe the name difference
    // is useful in catching misuse of the functions. Probably keep the names
    // different in this case
    //
    // *return a boolean on success or throw an Exception for unallowed movement?
    
    public boolean releaseFromTo(Enclosure enclosure, Exhibit exhibit)
    {
    }

    public boolean moveFromTo(Exhibit exhibit, Enclosure enclosure)
    {
    }
    */

    // [TODO]: consider removal
    public void exhibitMe(Exhibit exhibit)
    {
        releaseInto(exhibit);
        removeFrom(exhibit);
    }

    public static void main(String[] args)
    {
    }
}
