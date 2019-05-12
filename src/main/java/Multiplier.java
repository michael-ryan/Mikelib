import michaelryan.background.TaskCompleter;

public class Multiplier extends TaskCompleter<Float> {

    private float a;
    private float b;

    public Multiplier(float a, float b){
        this.a = a;
        this.b = b;
    }

    @Override
    protected Float doTask(){
        return this.a * this.b;
    }
}
