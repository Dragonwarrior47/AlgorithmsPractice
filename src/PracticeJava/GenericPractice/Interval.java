package PracticeJava.GenericPractice;

import java.io.Serializable;
import java.time.LocalDate;

public class Interval<T extends Comparable & Serializable> implements Serializable
{
    private T lower;
    private T upper;
    public Interval(T first, T second)
    {
        if (first.compareTo(second) <= 0) { lower = first; upper = second; }
        else { lower = second; upper = first; }
    }
}
