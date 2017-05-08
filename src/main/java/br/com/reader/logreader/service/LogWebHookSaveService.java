package br.com.reader.logreader.service;

import br.com.reader.logreader.entity.LogWebHook;
import br.com.reader.logreader.repository.LogWebHookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Flavio Andrade
 */
@Service
public class LogWebHookSaveService {

    private final LogWebHookRepository repository;

    @Autowired
    public LogWebHookSaveService(LogWebHookRepository repository) {
        this.repository = repository;
    }

    public void save(List<LogWebHook> logWebHooks) {
        repository.save(logWebHooks);
    }

}
