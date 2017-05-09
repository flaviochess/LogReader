package br.com.reader.logreader.repository;

import br.com.reader.logreader.entity.LogWebHook;
import br.com.reader.logreader.entity.LogWebHookCountReport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository of LogWebHook
 *
 * @author Flavio Andrade
 */
public interface LogWebHookRepository extends JpaRepository<LogWebHook, Long> {

    /**
     * Get "group by" with count of URLs by LogWebHook
     *
     * @return url count reports
     */
    @Query(value = "select new br.com.reader.logreader.entity.LogWebHookCountReport(l.url, count(l) as logCount) from LogWebHook l group by l.url order by logCount desc")
    List<LogWebHookCountReport> findUrlCount();

    /**
     * Get "group by" with count of status code by LogWebHook
     *
     * @return status code count reports
     */
    @Query(value = "select new br.com.reader.logreader.entity.LogWebHookCountReport(l.code, count(l) as logCount) from LogWebHook l group by l.code order by logCount desc")
    List<LogWebHookCountReport> findCodeCount();
}
