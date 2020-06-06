package br.com.kolibri.kolibri.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Configuration
class MapperDependencies {

    @Bean
    public MapperFactory getMapper() {
        return new DefaultMapperFactory.Builder().build();
    }
}