package src.busca;

import src.utils.DurationUtils;

import java.time.Duration;
import java.time.LocalDateTime;

abstract public class AbstractBusca implements Busca {
    //Executation
    private LocalDateTime initialTimeExecution;
    private LocalDateTime finalTimeExecution;

    @Override
    public String getExecutionTime() {
        Duration between = Duration.between(initialTimeExecution, finalTimeExecution);
        return DurationUtils.formatDuration(between);
    }

    protected void initializeTimeExecution() {
        this.initialTimeExecution = LocalDateTime.now();
    }

    protected void finalizeTimeExecution() {
        this.finalTimeExecution = LocalDateTime.now();
    }
}
