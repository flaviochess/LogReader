package br.com.reader.logreader.service;

import br.com.reader.logreader.entity.LogWebHookCountReport;
import br.com.reader.logreader.repository.LogWebHookRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Flavio Andrade
 */
@Service
public class LogWebHookReportService {

    private LogWebHookRepository repository;

    @Autowired
    public LogWebHookReportService(LogWebHookRepository repository) {
        this.repository = repository;
    }

    public List<LogWebHookCountReport> getTopUrls(Integer limit) {

        List<LogWebHookCountReport> reports = new ArrayList(limit);
        List<LogWebHookCountReport> urlsReport = repository.findUrlCount();

        for (int i = 0; i < urlsReport.size(); i++) {
            if (limit <= i) {
                break;
            }
            reports.add(urlsReport.get(i));
        }

        return reports;

    }
}
