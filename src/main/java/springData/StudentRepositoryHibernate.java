package springData;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import other.Student;

import javax.transaction.Transactional;
import java.util.List;


/**
 * В классе описывается методы для  работы с БД
 */
@Repository
public class StudentRepositoryHibernate {

    @Autowired
    SessionFactory sessionFactory;


    @Transactional
    public void saveStudent(Student student) {
         sessionFactory.getCurrentSession().save(student);
    }

    @Transactional
    public List<Student> findStudents() {
        List<Student> list = sessionFactory.getCurrentSession().createQuery("From Student").list();
        return list;
    }
}
