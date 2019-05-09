package michaelryan.background;

/**
 * A class that provides a framework for performing a task in the background. If the result of the task is requested
 * and computation has not finished, the calling thread "spins" until computation is complete.
 * <p>
 * This class must be extended, with the {@link #doTask()} method providing the implementation of the task. Such
 * implementation can save a created object if required, and retrieved with {@link #getResult()}
 * <p>
 * The only methods to be used by a calling thread are {@link #begin()} and {@link #getResult()}.
 *
 * @param <T> the return type of the task
 */
public abstract class TaskCompleter<T> implements Runnable {

    private T result;
    private boolean taskIsComplete;

    /**
     * Creates a new TaskCompleter object.
     */
    protected TaskCompleter(){
        this.taskIsComplete = false;
        this.result = null;
    }

    /**
     * Returns the result of the task.
     *
     * @return the result of the task
     */
    @SuppressWarnings("IdempotentLoopBody")
    public T getResult(){
        // TODO maybe enforce the task actually being started?
        boolean isComplete = false;
        while(!isComplete){
            synchronized(this){
                isComplete = this.taskIsComplete;
            }
        }
        return this.result;
    }

    @Override
    public void run(){
        this.result = this.doTask();
        synchronized(this){
            this.taskIsComplete = true;
        }
    }

    /**
     * Implements the task to execute. Must return the result of the computation, or {@code null} if not applicable
     *
     * @return the result of the task, or {@code null} if not applicable
     */
    protected abstract T doTask();

    /**
     * Begins execution of the task.
     */
    public void begin(){
        new Thread(this).start();
    }
}
