package caculator;

import functions.Transformer;

import java.util.function.*;

public class Calculator {

    public static Supplier<Calculator> instance = Calculator::new;

    public BinaryOperator<Integer> plus = (x, y) -> x + y;
    public BinaryOperator<Integer> minus = (x, y) -> x - y;
    public BinaryOperator<Integer> multiply = (x, y) -> x * y;

    //    public BinaryOperator<Integer> devide = (x, y) -> x/y;
    /*
    В данном коде происходит деление на ноль.
    Так как мы работаем с целыми числами, то при делении на 0 происходит выбрасывание исключения ArithmeticException.
    Для решения можно заменить тип Integer на Double, и тогда при делении на ноль будет возвращаться значение
    Double.POSITIVE_INFINITY или Double.POSITIVE_INFINITY
    Либо можно написать свой функциональный интерфейс, который принимает два параметра одного типа (Integer),
    а возвращает параметр другого типа (Double). Также в этом случае надо убрать типизацию у Consumer
     */
    public Transformer<Integer, Double> devide = (x, y) -> {
      if (y != 0) {
          return Double.valueOf(x/y);
      } else {
          return x > 0?Double.POSITIVE_INFINITY:Double.NEGATIVE_INFINITY;
      }
    };


    public UnaryOperator<Integer> pow = x -> x * x;
    public UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    public Predicate<Integer> isPositive = x -> x > 0;

    public Consumer println = System.out::println;
}
