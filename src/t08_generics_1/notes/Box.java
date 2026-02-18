package t08_generics_1.notes;

public class Box<T> {
    T value;

    public Box(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }
}
