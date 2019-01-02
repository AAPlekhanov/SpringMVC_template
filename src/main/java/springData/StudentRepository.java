package springData;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import other.Student;

import javax.transaction.Transactional;


/**
 * В классе описывается логига работы с БД
 */
@Repository
public class StudentRepository {

    @Autowired
    SessionFactory sessionFactory;


    @Transactional
    public void saveStudent(Student student) {
         sessionFactory.getCurrentSession().save(student);
    }
}
