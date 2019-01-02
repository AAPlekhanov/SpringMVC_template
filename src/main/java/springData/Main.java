package springData;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import other.Student;

public class Main {

    /**
     * простой пример использования через main Spring Data
     */

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MySpringDataConfig.class);


        StudentRepository studentRepository = context.getBean(StudentRepository.class);
        studentRepository.saveStudent(new Student("Max"));

//        DataBaseController dataBaseController = context.getBean(DataBaseController.class);
//        dataBaseController.createTable();

    }
}
