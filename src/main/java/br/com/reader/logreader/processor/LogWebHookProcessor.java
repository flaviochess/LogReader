package br.com.reader.logreader.processor;

import br.com.reader.logreader.adapter.MultipartFileAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Flavio Andrade
 */
@Component
public class LogWebHookProcessor implements LogProcessor {

    private MultipartFileAdapter fileAdapter;

    @Autowired
    public LogWebHookProcessor(MultipartFileAdapter fileAdapter) {
        this.fileAdapter = fileAdapter;
    }

    @Override
    public LogFileEnum getType() {
        return LogFileEnum.WEB_HOOK;
    }

    @Override
    public List<Map<String, Object>> convert(MultipartFile file) {

        List<String> lines = fileAdapter.adapt(file);

        //aqui converte para map pegando os campos desejados com regex

        return new ArrayList<>();
    }

}
