package com.skellas.jbehave;

import com.skellas.jbehave.domain.DomainConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DomainConfiguration.class})
@ComponentScan
public class AcceptanceTestsConfiguration {
}
