package br.com.reader.logreader.processor;

import br.com.reader.logreader.adapter.MultipartFileAdapter;
import br.com.reader.logreader.entity.LogWebHook;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Flavio Andrade
 */
@Component
public class LogWebHookProcessor implements LogProcessor {

    private static final String URL_REGEX = "request_to=\"(.*?)\"";
    private static final String CODE_REGEX = "response_status=\"(.*?)\"";
    
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

        List<Map<String, Object>> values = new ArrayList();
        
        List<String> lines = fileAdapter.adapt(file);

        Pattern urlPattern = Pattern.compile(URL_REGEX);
        Pattern codePattern = Pattern.compile(CODE_REGEX);
        
        for (String line : lines) {
            Matcher urlMatcher = urlPattern.matcher(line);
            Matcher codeMatcher = codePattern.matcher(line);
            if(urlMatcher.find() && codeMatcher.find()) {
                Map<String, Object> value = new HashMap();
                value.put(LogWebHook.URL_FIELD, urlMatcher.group(1));
                value.put(LogWebHook.CODE_FIELD, codeMatcher.group(1));
                
                values.add(value);
            }
        }

        return values;
    }

}
