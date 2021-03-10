package PracticeJava.GenericPractice;

import java.time.LocalDate;
import java.util.ArrayList;

public class Generics {
    private final StringBuilder evaluations;
    private final String s;

    public Generics() {
        evaluations = new StringBuilder();
        s = "kanhaiya";
    }

    public static void main(String[] args) {
        Generics gs = new Generics();
        System.out.println(gs.evaluations.toString());
        gs.giveGoldStar();
        System.out.println(gs.evaluations.toString());

    }
    public void giveGoldStar()
    {
        evaluations.append(LocalDate.now() + ": Gold star!\n");
    }

    public static <T> void addAll(T... ts) {
        ArrayList<T> coll = new ArrayList<>();
        for (T t : ts) coll.add(t);
        System.out.println(coll.get(0).getClass());

    }

    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }

    static class Pair<T> {
        private T first;
        private T second;

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }

        public Pair() {
            first = null;
            second = null;
        }

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }

        public void setFirst(T newValue) {
            first = newValue;
        }

        public void setSecond(T newValue) {
            second = newValue;
        }
    }
}
