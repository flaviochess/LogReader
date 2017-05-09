package br.com.reader.logreader.entity;

/**
 * Object for reports of LogWebHook
 *
 * @author Flavio Andrade
 */
public class LogWebHookCountReport {

    private String value;
    
    private Long count;

    public LogWebHookCountReport() {
    }

    public LogWebHookCountReport(String value, Long count) {
        this.value = value;
        this.count = count;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
    
    
}
