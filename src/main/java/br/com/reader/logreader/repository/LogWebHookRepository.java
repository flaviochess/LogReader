package br.com.reader.logreader.repository;

import br.com.reader.logreader.entity.LogWebHook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Flavio Andrade
 */
public interface LogWebHookRepository extends JpaRepository<LogWebHook, Long> {

}
