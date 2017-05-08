package br.com.reader.logreader.processor;

import br.com.reader.logreader.processor.LogFileEnum;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Flavio Andrade
 */
public interface LogProcessor {

    public LogFileEnum getType();

    public List<Map<String, Object>> convert(MultipartFile file);

}
