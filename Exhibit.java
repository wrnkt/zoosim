import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDateTime;

public class Exhibit
{
    private final LoudSpeaker loudspeaker;

    private ArrayList<Animal> currentlyShowing = new ArrayList<>();
    private ArrayList<Animal> animalsShown = new ArrayList<>();

    private HashMap<LocalDateTime, Animal> lastShowings = new HashMap<>();

    public Exhibit()
    {
        loudspeaker = new LoudSpeaker();
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
                    "Showing Animal#%d %s in Exhibit#%d",
                    animal.getAnimalID(),
                    animal.getName(),
                    8008
                    ));
    }

    public void removeAnimal(Animal animal)
    {
        currentlyShowing.remove(animal);

        Logger.log(String.format(
                    "Removing Animal#%d %s from Exhibit#%d",
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
