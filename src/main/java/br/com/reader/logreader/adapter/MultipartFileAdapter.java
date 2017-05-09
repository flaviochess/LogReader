package br.com.reader.logreader.adapter;

import br.com.reader.logreader.processor.LogWebHookProcessor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Adapter of MultipartFile
 *
 * @author Flavio Andrade
 */
@Component
public class MultipartFileAdapter {

    /**
     * Adapt lines of MultipartFile in String list
     *
     * @param file - MultipartFile
     * @return lines in String list
     */
    public List<String> adapt(MultipartFile file) {
        List<String> lines = new ArrayList();

        String line;

        try (InputStreamReader inputStreamReader = new InputStreamReader(file.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException ex) {
            Logger.getLogger(LogWebHookProcessor.class.getName()).log(Level.SEVERE, "Falha ao processar o arquivo", ex);
        }

        return lines;
    }
}
