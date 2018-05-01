package src.busca;

abstract public class AbstractBusca implements Busca {
    //Executation
    private long initialTimeExecution = 0;
    private long finalTimeExecution = 0;

    @Override
    public String getExecutionTime() {
        long time = finalTimeExecution - initialTimeExecution;

        if (time < 0) return Float.toString(0);
        return Float.toString(time);
    }

    public void initializeTimeExecution() {
        this.initialTimeExecution = System.currentTimeMillis();
    }

    public void finalizeTimeExecution() {
        this.finalTimeExecution = System.currentTimeMillis();
    }
}
