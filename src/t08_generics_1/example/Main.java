static class Result<T> {
    private T _value;
    private String _error;

    private Result(T value, String error) {
        _value = value;
        _error = error;
    }

    public static <T> Result<T> ok(T value) {
        return new Result<>(value, null);
    }

    public static <T> Result<T> fail(String error) {
        return new Result<>(null, error);
    }

    public boolean isOk() {
        return _error == null;
    }

    public T value() {
        return _value;
    }

    public String error() {
        return _error;
    }
}


void main() {
    Result<Integer> r = Result.ok(10);
    if (r.isOk())
        System.out.println(r.value() + 5);
}
