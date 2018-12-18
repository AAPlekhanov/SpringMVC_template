//package config;
//
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
///**
// * инициализация Spring MVC через аннотации ( Файлов dispatcher-servlet.xml и web.xml не должно быть чтобы не было конфликтов)
// */
//
//
//
//public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
//    // Этот метод должен содержать конфигурации которые инициализируют Beans
//    // для инициализации бинов у нас использовалась аннотация @Bean
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class<?>[]{
//                MyWebConfig.class
//        };
//    }
//
//    // Тут добавляем конфигурацию, в которой инициализируем ViewResolver
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//
//        return new Class<?>[]{
//                MyWebConfig.class
//        };
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//}