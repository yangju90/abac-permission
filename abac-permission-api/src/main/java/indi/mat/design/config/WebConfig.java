package indi.mat.design.config;

import indi.mat.design.casbin.EnforcerAdapter;
import indi.mat.design.service.permission.IMetaService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Mat
 * @version : WebConfig, v 0.1 2022-11-30 0:06 Yang
 */
@Configuration
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware, ApplicationListener<WebServerInitializedEvent> {

    private ApplicationContext applicationContext;

    private int port;

    @Autowired
    private EnforcerAdapter adapter;

    @Autowired
    private IMetaService service;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.port = event.getWebServer().getPort();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionInterceptor(adapter, service)).addPathPatterns("/**");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
