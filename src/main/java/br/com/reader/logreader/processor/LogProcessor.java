package br.com.reader.logreader.processor;

import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Flavio Andrade
 */
public interface LogProcessor {

    /**
     * Indicates which type of log the processor knows
     *
     * @return Log type
     */
    public LogFileEnum getType();

    /**
     * Convert a MultipartFile in list of lines separated by attributes on a map
     *
     * @param file - MultipartFile that represents the log file
     * @return List of file lines separated by attributes on a map
     */
    public List<Map<String, Object>> convert(MultipartFile file);

}
