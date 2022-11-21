public class Animal implements Exhibitable<Exhibit>
{

    private boolean beingShown = false;

    public void releaseInto(Exhibit e)
    {
        e.showAnimal(this);
        beingShown = true;
    }

    public void removeFrom(Exhibit e)
    {
        e.removeAnimal(this);
        beingShown = false;
    }

    public void exhibitMe(Exhibit e)
    {
        releaseInto(e);
        removeFrom(e);
    }

    public static void main(String[] args)
    {
    }
}
