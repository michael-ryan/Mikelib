package michaelryan.background.examples;

import michaelryan.background.TaskCompleter;

public class Sleeper extends TaskCompleter {

    private long millis;

    public Sleeper(long millis){
        super();
        this.millis = millis;
    }

    @Override
    protected Object doTask(){
        try {
            Thread.sleep(millis);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
