package com.mellon.platform.util;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 15-11-24.
 */
@Configuration
public class EssaSwaggerSpringMvcPlugin {
    private SpringSwaggerConfig springSwaggerConfig;

    private Boolean enable;

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * Required to autowire SpringSwaggerConfig
     */
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig)
    {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    /**
     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
     * framework - allowing for multiple swagger groups i.e. same code base
     * multiple swagger resource listings.
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation()
    {
        SwaggerSpringMvcPlugin p =new SwaggerSpringMvcPlugin(this.springSwaggerConfig).enable(this.enable);
        return p;
    }

}
