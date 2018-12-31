package excercises.fibonacci;

import exercices.fibonacci.Fibonacci;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class FibonacciTest {

    @Test
    public void test_fib_2() {
        Fibonacci solution = new Fibonacci ();
        assertThat(solution.evenFibonacci(100)).isEqualTo(44);
    }

    @Test
    public void test_fib_4() {
        Fibonacci solution = new Fibonacci ();
        assertThat(solution.evenFibonacci(10000)).isEqualTo(3382);
    }

    @Test
    public void test_fib_6() {
        Fibonacci solution = new Fibonacci ();
        assertThat(solution.evenFibonacci(1_000_000)).isEqualTo(1089154);
    }

    /*
    @Test
    public void test_fib_ten() {
        Fibonacci solution = new Fibonacci ();
        assertThat(solution.evenFibonacci(10_000_000_000L)).isEqualTo(1998167216L);
    }
    */
}