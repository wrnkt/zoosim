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

    private void speakLoudSpeaker(String s)
    {
        loudspeaker.speak(s);
    }

    public static void main(String[] args)
    {
        Exhibit testExhibit1 = new Exhibit();
        testExhibit1.speakLoudSpeaker("HELLO ANIMAL LOVERS");
    }

}
