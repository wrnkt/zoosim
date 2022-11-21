public class Animal implements Exhibitable<Exhibit>
{

    public void releaseInto(Exhibit e)
    {
        System.out.println();
    }

    public void removeFrom(Exhibit e)
    {
        System.out.println();
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
