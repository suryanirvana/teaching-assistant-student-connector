package group2.TASC.config;

import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.micrometer.core.aop.TimedAspect; //add this import

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class RegistryConfig {

    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry ->  registry.config().commonTags("app.name","TASC");
    }

    @Bean
    TimedAspect  timedAspect(MeterRegistry  registry) {
        return  new  TimedAspect(registry);
    }

}
