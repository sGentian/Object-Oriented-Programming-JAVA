package james_app;

public interface MyList<T> {

    boolean add(T element);

    T get(int idx);

    int size();
}