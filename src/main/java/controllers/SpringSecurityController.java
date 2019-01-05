package controllers;


import config.spring_security.SecurityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableWebSecurity   // @EnableWebSecurity is a marker annotation
public class SpringSecurityController {

    @Autowired
    SecurityClass securityClass;

    @RequestMapping("/test")
    public String springSecurityTest(){
        return "testSpringSecurity";
    }


    @RequestMapping("/securityMethod")
    @ResponseBody
    public String testSecurityMethod() {
        securityClass.securityMetod();  // вызов защищённого метода ( требуется роль 'admin' )
        return "test security method";
    }

}
