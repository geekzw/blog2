package com.gzw.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.Ssl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gujian on 2017/7/19.
 */
@Configuration
public class WebConfig {

//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//        return new EmbeddedServletContainerCustomizer() {
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer container) {
//                Ssl ssl = new Ssl();
//                ssl.setKeyStore("Server.jks");
//                ssl.setKeyStorePassword("888888");
//                container.setSsl(ssl);
//                container.setPort(8088);
//            }
//        };
//    }
}
