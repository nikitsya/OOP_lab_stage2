package t08_generics_1.notes;

public class BoxObject {
    Object value;

    public BoxObject(Object value) {
        this.value = value;
    }

    public Object value() {
        return value;
    }
}
