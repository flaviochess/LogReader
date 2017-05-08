package br.com.reader.logreader.webhook;

import br.com.reader.logreader.entity.LogWebHook;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Flavio Andrade
 */
@Controller
@RequestMapping("/report")
public class WebHookController {

    @RequestMapping(method = RequestMethod.GET)
    public String listaTeste(Model model) {
        LogWebHook webHook = new LogWebHook();
        webHook.setUrl("https://google.com");
        webHook.setCode("200");

        List<LogWebHook> results = Collections.singletonList(webHook);

        model.addAttribute("report", results);

        return "showReport";
    }
}
