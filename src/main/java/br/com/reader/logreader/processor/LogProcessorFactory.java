package br.com.reader.logreader.processor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Processor factory
 *
 * @author Flavio Andrade
 */
@Component
public class LogProcessorFactory {

    private List<LogProcessor> processors;

    @Autowired
    public LogProcessorFactory(List<LogProcessor> processors) {
        this.processors = processors;
    }

    /**
     * Creates processor by log type
     *
     * @param logFile - log type
     * @return processor of log type
     */
    public LogProcessor create(LogFileEnum logFile) {
        return processors.stream()
                .filter(processor -> LogFileEnum.WEB_HOOK.equals(processor.getType()))
                .findFirst()
                .get();
    }
}
