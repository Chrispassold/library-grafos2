package src.busca;

abstract public class AbstractBusca implements Busca {
    //Executation
    private long initialTimeExecution;
    private long finalTimeExecution;

    @Override
    public String getExecutionTime() {
        return Float.toString(finalTimeExecution - initialTimeExecution) + " milliseconds";
    }

    protected void initializeTimeExecution() {
        this.initialTimeExecution = System.currentTimeMillis();
    }

    protected void finalizeTimeExecution() {
        this.finalTimeExecution = System.currentTimeMillis();
    }
}
