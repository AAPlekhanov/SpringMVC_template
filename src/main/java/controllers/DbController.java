package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DbController {

    @Autowired
     JdbcOperations jdbcOperations;

    @RequestMapping("/createTable")
    @ResponseBody
    public String createTable () {
        jdbcOperations.execute("create TABLE User (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(50), PRIMARY KEY  (id))");
        return "Data base was created";
    }
}
