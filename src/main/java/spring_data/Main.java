package spring_data;

import config.MySpringDataConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MySpringDataConfig.class);

       UserRepository userRepository = context.getBean(UserRepository.class);

       userRepository.createTable();
    }

}
