public class LoudSpeaker
{
    static int totalLoudSpeakers;
    private int speakerNumber;

    static int totalParkAnnouncements;
    private int totalSpeakerAnnouncements;

    public LoudSpeaker()
    {
        // Logger.log("Creating Loudspeaker");
        totalLoudSpeakers++;
        speakerNumber = totalLoudSpeakers; // numbered from 1
    }

    public void speak(String announcement)
    {
        System.out.println(String.format("Speaker #%d: %s", totalLoudSpeakers, announcement));
        totalParkAnnouncements++;
        totalSpeakerAnnouncements++;
    }
}
