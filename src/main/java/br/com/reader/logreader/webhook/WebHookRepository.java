package br.com.reader.logreader.webhook;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Flavio Andrade
 */
public interface WebHookRepository extends JpaRepository<WebHook, Long> {

}
