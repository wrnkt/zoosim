import java.time.Duration;

public abstract interface Housable<T>
{

    public abstract void releaseInto(T e);
    public abstract void removeFrom(T e);

    public default void showAnimal(T e, Duration duration)
    {
        releaseInto(e);
        removeFrom(e);
    }

}
