package indi.mat.design.qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mat
 * @version : InjectConfiguration, v 0.1 2023-03-02 21:31 Yang
 */

@Configuration
public class InjectConfiguration {

    @Bean
    @InjectToList
    public InjectObject get(){
        return new InjectObject() {
            @Override
            public String get() {
                return "xxxxx";
            }
        };
    }


    @Bean
    @InjectToList
    public InjectObject get1(){
        return new InjectObject() {
            @Override
            public String get() {
                return "yyyyy";
            }
        };
    }
}
