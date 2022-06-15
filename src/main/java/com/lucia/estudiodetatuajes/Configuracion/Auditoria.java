package com.lucia.estudiodetatuajes.Configuracion;
import com.lucia.estudiodetatuajes.upload.StorageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@Configuration
@EnableJpaAuditing
@EnableConfigurationProperties(StorageProperties.class)
class Auditoria {

}
