import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDateTime;

public class Exhibit
{
    final LoudSpeaker loudspeaker;

    ArrayList<Animal> animalsShown = new ArrayList<>();

    HashMap<LocalDateTime, Animal> lastShowings = new HashMap<>();

    {
        loudspeaker = new LoudSpeaker();
    }

    

    public static void main(String[] args)
    {
        Logger.log("TEST");
    }

}
