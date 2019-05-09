package michaelryan.background.examples;

import michaelryan.background.TaskCompleter;

public class FactorialComputer extends TaskCompleter<Long> {

    private int factorial;

    public FactorialComputer(int factorial){
        super();
        this.factorial = factorial;
    }

    @Override
    protected Long doTask(){
        long answer = 1l;

        for(int i = 2; i <= this.factorial; i++){
            answer *= i;
        }

        return answer;
    }
}
