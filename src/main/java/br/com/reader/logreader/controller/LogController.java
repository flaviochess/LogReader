package br.com.reader.logreader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Flavio Andrade
 */
@Controller
public class LogController {

    @GetMapping("/")
    public String logUploadPage(Model model) {
        return "logUpload";
    }

    @PostMapping("/")
    public String logUpload(@RequestParam("log") MultipartFile log, Model model) {
        try {
            model.addAttribute("message", "Arquivo " + log.getName() + " enviado com sucesso");
        } catch (Exception e) {
            model.addAttribute("message", "Ocorreu um erro ao subir o arquivo");
        }
        return "logUpload";
    }
}
