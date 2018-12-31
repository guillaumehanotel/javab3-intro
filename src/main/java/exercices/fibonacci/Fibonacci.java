package exercices.fibonacci;

public class Fibonacci {


    public long evenFibonacci(long n) {

        if(n < 2) return 0;

        int first_term = 1;
        int second_term = 2;

        long sum = second_term;

        while(second_term + first_term < n){

            int tmp_first_term = first_term;
            first_term = second_term;
            second_term = tmp_first_term + second_term;

            if(isPair(second_term))
                sum += second_term;

        }

        return sum;
    }


    private boolean isPair(int n){
        return n % 2 == 0;
    }

}
