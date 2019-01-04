package controllers;


import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableWebSecurity   // @EnableWebSecurity is a marker annotation
public class SpringSecurityController {

    @RequestMapping("/test")
    public String springSecurityTest(){
        return "testSpringSecurity";
    }
}
