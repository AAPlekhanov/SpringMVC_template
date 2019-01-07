package springData;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public class DataBaseControllerJDBC {

    //  JdbcOperations или JdbcTemplate
    @Autowired
    JdbcOperations jdbcOperations;


    public void createTable(){
        jdbcOperations.execute("create TABLE User (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(50), PRIMARY KEY  (id))");
    }
}
