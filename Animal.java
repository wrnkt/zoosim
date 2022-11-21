public class Animal implements Exhibitable<Exhibit>
{

    private boolean beingShown = false;

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
