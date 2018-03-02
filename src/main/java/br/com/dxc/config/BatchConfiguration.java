package br.com.dxc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:/META-INF/batch-config.xml"})
public class BatchConfiguration {

}
