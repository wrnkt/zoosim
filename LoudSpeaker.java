public class LoudSpeaker
{
    static int totalLoudSpeakers;
    private int speakerNumber;

    static int totalParkAnnouncements;
    private int totalSpeakerAnnouncements;

    public void LoudSpeaker()
    {
        totalLoudSpeakers++;
        speakerNumber = totalLoudSpeakers; // numbered from 1
    }

    public void speak(String s)
    {
        totalParkAnnouncements++;
        totalSpeakerAnnouncements++;
        System.out.println(String.format("Speaker #%d: ", speakerNumber));
    }
}
