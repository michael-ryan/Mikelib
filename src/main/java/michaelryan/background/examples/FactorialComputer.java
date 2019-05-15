package michaelryan.background.examples;

import michaelryan.background.TaskCompleter;

/**
 * An example implementation of {@link TaskCompleter} which calculates the factorial of a given number.
 */
public class FactorialComputer extends TaskCompleter<Long> {

    private final int factorial;

    /**
     * Constructs a new FactorialComputer with the specified number to find the factorial of.
     *
     * @param factorial the number to find the factorial of
     */
    public FactorialComputer(int factorial){
        super();
        this.factorial = factorial;
    }

    @Override
    protected Long doTask(){
        long answer = 1L;

        for(int i = 2; i <= this.factorial; i++){
            answer *= i;
        }

        return answer;
    }
}
