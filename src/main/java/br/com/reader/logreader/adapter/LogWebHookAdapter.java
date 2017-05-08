package br.com.reader.logreader.adapter;

import br.com.reader.logreader.entity.LogWebHook;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Flavio Andrade
 */
public class LogWebHookAdapter {

    public List<LogWebHook> adapt(List<Map<String, Object>> mapLogWebHooks) {
        List<LogWebHook> logWebHooks = new ArrayList();

        mapLogWebHooks.forEach((mapLogWebHook) -> {
            logWebHooks.add(adapt(mapLogWebHook));
        });

        return logWebHooks;
    }

    public LogWebHook adapt(Map<String, Object> mapLogWebHook) {
        LogWebHook logWebHook = new LogWebHook();
        logWebHook.setUrl(mapLogWebHook.get("url").toString());
        logWebHook.setCode(mapLogWebHook.get("code").toString());

        return logWebHook;
    }
}
