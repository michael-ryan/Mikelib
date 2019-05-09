package michaelryan.background.examples;

import michaelryan.background.TaskCompleter;

/**
 * An example implementation of {@link TaskCompleter} which sleeps for the specified amount of time.
 */
public class Sleeper extends TaskCompleter {

    private long millis;

    /**
     * Constructs a new Sleeper with the specified number of milliseconds to sleep for.
     *
     * @param millis the number of milliseconds to sleep for
     */
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
