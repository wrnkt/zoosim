import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.*;

import java.lang.IllegalArgumentException;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.Duration;


public class Animal implements Housable<Exhibit<Animal>>
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
    
    public long getAgeInSeconds()
    {
        LocalDateTime now = LocalDateTime.now();
        Duration age = Duration.between(birthday, now);

        return age.toSeconds();
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
                "Animal ID #%d\nName: %s\nAge (in seconds): %d\n",
                getAnimalID(),
                getName(),
                getAgeInSeconds()
                );
    }

    public void releaseInto(Exhibit<Animal> exhibit)
    {
        exhibit.showAnimal(this);
        beingShown = true;
    }

    public void removeFrom(Exhibit<Animal> exhibit)
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

    
    /*
    // [TODO]: 
    // filter by name
    // filter by weight
    // filter by age
    public static List<Animal> filterAnimals()
    {
        
    }
    */
    
    public static List<Animal> sortAnimalListBy(List<Animal> animalList, String sortChoice) throws IllegalArgumentException
    {
        if (sortChoice.equals("age") || sortChoice.equals("birthday"))
        {
            Comparator<Animal> byAge =
                (a1, a2) -> (int) (a1.getAgeInSeconds() - a2.getAgeInSeconds());
            Collections.sort(animalList, byAge);
        }
        else
        {
            throw new IllegalArgumentException(String.format("Unable to sort by specified property: %d", sortChoice));
        }

        return animalList; // after sorting
    }

    public static void printAnimalsInList(List<Animal> animalList)
    {
        Stream<Animal> animals = animalList.stream();
        animals.forEach(System.out::println);
    }
    
    public static void printAnimalLedger()
    {
        System.out.println("animalLedger contents: ");
        printAnimalsInList(animalLedger);
    }

    public static void main(String[] args)
    {
    }
}
