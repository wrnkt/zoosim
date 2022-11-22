import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDateTime;

public class Exhibit
{
    private String name;
    private final LoudSpeaker loudspeaker = new LoudSpeaker();

    private ArrayList<Animal> currentlyShowing = new ArrayList<>();
    private ArrayList<Animal> animalsShown = new ArrayList<>();

    private HashMap<LocalDateTime, Animal> lastShowings = new HashMap<>();

    public Exhibit()
    {
        setName("");
    }

    public Exhibit(String name)
    {
        setName(name);
    }

    public String getName()
    {
        return name;
    }

    private void setName(String name)
    {
        this.name = name;
    }

    private void announce()
    {
    }

    public void showAnimal(Animal animal)
    {
        currentlyShowing.add(animal);
        animalsShown.add(animal);
        lastShowings.put(LocalDateTime.now(), animal);

        Logger.log(String.format(
                    "Showing Animal#%04d %s in Exhibit#%02d",
                    animal.getAnimalID(),
                    animal.getName(),
                    8008
                    ));
    }

    public void removeAnimal(Animal animal)
    {
        currentlyShowing.remove(animal);

        Logger.log(String.format(
                    "Removing Animal#%04d %s from Exhibit#%02d",
                    animal.getAnimalID(),
                    animal.getName(),
                    8008
                    ));
    }

    private void speakLoudSpeaker(String s)
    {
        loudspeaker.speak(s);
    }

    public static void main(String[] args)
    {
        Exhibit testExhibit1 = new Exhibit();
        Animal testAnimal = new Animal();
        testExhibit1.speakLoudSpeaker("HELLO ANIMAL LOVERS");
        testExhibit1.showAnimal(testAnimal);
        testExhibit1.removeAnimal(testAnimal);
    }

}
