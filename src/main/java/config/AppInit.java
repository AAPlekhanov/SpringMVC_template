package config;


import config.spring_security.SpringSecurityInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * инициализация Spring MVC через аннотации ( Файлов dispatcher-servlet.xml и web.xml не должно быть чтобы не было конфликтов)
 * аналог web.xml
 */



public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[]{
                MyWebConfig.class, WebFlowConfig.class , SpringSecurityInitializer.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    // опционально (для конфигурации простого Spring mvc)
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // путь сохранения файлов
      registration.setMultipartConfig(new MultipartConfigElement("/tmp/app/uploads"));
    }
}