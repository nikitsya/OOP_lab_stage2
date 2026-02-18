package t08_generics_1.exercises.ex09;

import java.util.function.Function;

final class Result<T> {

    private final T _value;
    private final String _error;

    private Result(T value, String error) {
        _value = value;
        _error = error;
    }

    public static <T> Result<T> ok(T value) {
        return new Result<>(value, null);
    }

    public static <T> Result<T> fail(String error) {
        if (error == null) {
            throw new NullPointerException("Error can't be null");
        }
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

    public <R> Result<R> map(Function<T, R> f) {
        if (f == null) throw new NullPointerException("f must not be null");
        if (!isOk()) return Result.fail(_error);

        return Result.ok(f.apply(_value));
    }
}

public class Exercise {
    public static void run() {
        Result<Integer> hp = Result.ok(10);
        Result<String> label = hp.map(n -> "HP:" + n);
        System.out.println(label.value()); // HP:10

        Result<Integer> bad = Result.fail("No HP");
        Result<String> stillBad = bad.map(n -> "HP:" + n);
        System.out.println(stillBad.isOk());  // false
        System.out.println(stillBad.error()); // No HP
    }
}
