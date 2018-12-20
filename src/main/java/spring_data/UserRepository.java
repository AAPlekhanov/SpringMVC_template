package spring_data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {


    //JdbcTemplate или JdbcOperations
    @Autowired
    JdbcOperations jdbcOperations;

    public void createTable() {
        jdbcOperations.execute(" нативный запрос к БД");
    }
}
