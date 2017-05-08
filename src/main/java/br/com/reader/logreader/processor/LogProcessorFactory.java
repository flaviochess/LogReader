package br.com.reader.logreader.processor;

import br.com.reader.logreader.processor.LogFileEnum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
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

    public LogProcessor create(LogFileEnum logFile) {
        return processors.stream()
                .filter(processor -> LogFileEnum.WEB_HOOK.equals(processor.getType()))
                .findFirst()
                .get();
    }
}
