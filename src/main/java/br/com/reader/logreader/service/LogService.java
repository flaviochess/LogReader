package br.com.reader.logreader.service;

import br.com.reader.logreader.service.LogWebHookSaveService;
import br.com.reader.logreader.entity.LogWebHook;
import br.com.reader.logreader.processor.LogFileEnum;
import br.com.reader.logreader.processor.LogProcessor;
import br.com.reader.logreader.processor.LogProcessorFactory;
import br.com.reader.logreader.adapter.LogWebHookAdapter;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Flavio Andrade
 */
@Service
public class LogService {

    private final LogProcessorFactory logProcessorFactory;

    private final LogWebHookSaveService logWebHookSave;

    @Autowired
    public LogService(LogProcessorFactory logProcessorFactory, LogWebHookSaveService logWebHookSave) {
        this.logProcessorFactory = logProcessorFactory;
        this.logWebHookSave = logWebHookSave;
    }

    public void saveLogWebHook(MultipartFile log) {

        LogProcessor logProcessor = logProcessorFactory.create(LogFileEnum.WEB_HOOK);
        List<Map<String, Object>> mapLogWebHooks = logProcessor.convert(log);

        List<LogWebHook> logWebHooks = new LogWebHookAdapter().adapt(mapLogWebHooks);

        logWebHookSave.save(logWebHooks);
    }
}
