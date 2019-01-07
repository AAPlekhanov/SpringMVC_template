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

        // тест hibernate
        StudentRepositoryHibernate studentRepository = context.getBean(StudentRepositoryHibernate.class);
        studentRepository.saveStudent(new Student("Max"));



        //  тест JDBC
//        DataBaseControllerJDBC dataBaseController = context.getBean(DataBaseControllerJDBC.class);
//        dataBaseController.createTable();

    }
}
