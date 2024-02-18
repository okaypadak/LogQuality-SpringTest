package dev.test;

import ch.qos.logback.classic.LoggerContext;
import dev.padak.LogQualityConfig;
import dev.padak.LogQualityDepency;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@Import({LogQualityDepency.class})
public class AppConfig {

    @Autowired
    LogQualityConfig logQualityConfig;
    @Bean
    public void LogConfiguration() {
        logQualityConfig.configureLogback((LoggerContext) LoggerFactory.getILoggerFactory());
    }

}

