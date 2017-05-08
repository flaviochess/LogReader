package br.com.reader.logreader.service;

import br.com.reader.logreader.service.LogWebHookSaveService;
import br.com.reader.logreader.entity.LogWebHook;
import br.com.reader.logreader.processor.LogFileEnum;
import br.com.reader.logreader.processor.LogProcessor;
import br.com.reader.logreader.processor.LogProcessorFactory;
import br.com.reader.logreader.adapter.LogWebHookAdapter;
import br.com.reader.logreader.entity.LogWebHookCountReport;
import java.util.ArrayList;
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

    private final LogWebHookReportService logWebHookReport;
    
    @Autowired
    public LogService(LogProcessorFactory logProcessorFactory, LogWebHookSaveService logWebHookSave, LogWebHookReportService logWebHookReport) {
        this.logProcessorFactory = logProcessorFactory;
        this.logWebHookSave = logWebHookSave;
        this.logWebHookReport = logWebHookReport;
    }

    public void saveLogWebHook(MultipartFile log) {

        LogProcessor logProcessor = logProcessorFactory.create(LogFileEnum.WEB_HOOK);
        List<Map<String, Object>> mapLogWebHooks = logProcessor.convert(log);

        List<LogWebHook> logWebHooks = new LogWebHookAdapter().adapt(mapLogWebHooks);

        logWebHookSave.save(logWebHooks);
        
    }
    
    public List<LogWebHookCountReport> getTopUrls(Integer limit) {
        if (limit != null) {
            return logWebHookReport.getTopUrls(limit);
        }
        
        return new ArrayList();
    }
    
    public List<LogWebHookCountReport> getStatusCodeReport() {
        
        return logWebHookReport.getStatusCodeReport();
    }
    
}
