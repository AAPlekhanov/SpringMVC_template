
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import other.Student;
import other.User;
import springData.StudentRepositoryHibernate;

import javax.transaction.Transactional;
import java.util.List;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ConfigurationForTestDb.class, StudentRepositoryHibernate.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  // очерёдность выполнения тестов
public class TestDb {


    @Autowired
    StudentRepositoryHibernate studentRepository;


    @Test
    @Transactional   // по умолчанию делается rollback
    @Commit          // сохраняем User не делая rollback
    public void aTestSaveStudent() {
        studentRepository.saveStudent(new Student("Max"));
    }

    @Test
    @Transactional
    public void bTestFindStudents() {
        List<Student> list = studentRepository.findStudents();
        Assert.assertEquals(1, list.size());
        Assert.assertEquals("Max", list.get(0).getName());
    }

}
