package net.kiel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by kiel on 2016. 4. 19..
 */
@Configuration
@EnableJpaAuditing
public class AuditConfig {
}
