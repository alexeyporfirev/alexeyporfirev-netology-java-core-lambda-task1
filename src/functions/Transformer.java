package functions;

@FunctionalInterface
public interface Transformer<T, R> {
     R apply(T a, T b);
}
