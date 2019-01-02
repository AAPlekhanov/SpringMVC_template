package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import other.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

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


    // возвращает книгу из БД по id
    @RequestMapping("/getBook/{id}")
    @ResponseBody
    public String getBook(@PathVariable ("id") String id) {
       Book book =  jdbcOperations.queryForObject("select * from books where id =" +id, new BookMapper());
       return book.toString();
    }


    static class BookMapper implements RowMapper<Book> {

        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Book(resultSet.getInt("ID"),
                    resultSet.getString("BOOK_TITLE"),
                    resultSet.getString("BOOK_AUTHOR"),
                    resultSet.getInt("BOOK_PRICE"));
        }
    }
}
