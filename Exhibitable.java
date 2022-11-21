public abstract interface Exhibitable<T>
{
    public abstract void announce(T e);
    public default void exhibitMe(T e)
    {
        releaseInto(e);
        removeFrom(e);
    }
    public abstract void releaseInto(T e);
    public abstract void removeFrom(T e);

}
