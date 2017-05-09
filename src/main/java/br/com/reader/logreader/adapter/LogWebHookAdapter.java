package br.com.reader.logreader.adapter;

import br.com.reader.logreader.entity.LogWebHook;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Adapter of LogWebHook
 *
 * @author Flavio Andrade
 */
public class LogWebHookAdapter {

    /**
     * Adapt of line list to LogWebHook list
     *
     * @param mapLogWebHooks - line list of log file
     * @return list of LogWebHook
     */
    public List<LogWebHook> adapt(List<Map<String, Object>> mapLogWebHooks) {
        List<LogWebHook> logWebHooks = new ArrayList();

        mapLogWebHooks.forEach((mapLogWebHook) -> {
            logWebHooks.add(adapt(mapLogWebHook));
        });

        return logWebHooks;
    }

    /**
     * Adapt of line of log file in LogWebHook
     *
     * @param mapLogWebHook - line of log file
     * @return LogWebHook
     */
    public LogWebHook adapt(Map<String, Object> mapLogWebHook) {
        LogWebHook logWebHook = new LogWebHook();
        logWebHook.setUrl(mapLogWebHook.get("url").toString());
        logWebHook.setCode(mapLogWebHook.get("code").toString());

        return logWebHook;
    }
}
