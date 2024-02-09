package dev.test;

import ch.qos.logback.classic.LoggerContext;
import dev.padak.LogQualityConfig;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@Import(LogQualityConfig.class)
public class AppConfig {

    @Bean
    public void LogConfiguration() {

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();;
        dev.padak.LogConfiguration.configureLogback(loggerContext);

    }

}

