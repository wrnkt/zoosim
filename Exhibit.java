import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDateTime;

public class Exhibit
{
    private final LoudSpeaker loudspeaker;

    private ArrayList<Animal> animalsShown = new ArrayList<>();

    private HashMap<LocalDateTime, Animal> lastShowings = new HashMap<>();

    public Exhibit()
    {
        // Logger.log("Creating Exhibit");
        loudspeaker = new LoudSpeaker();
    }

    private void announce()
    {
    }

    public void showAnimal(Animal a)
    {
        animalsShown.add(a);
        Logger.log(String.format("Showing animal in exhibit"));
    }

    public void removeAnimal(Animal a)
    {
        Logger.log(String.format("Removing animal from exhibit"));
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
