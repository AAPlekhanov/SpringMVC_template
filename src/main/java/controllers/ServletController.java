package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Controller
public class ServletController {


    @RequestMapping("/servlet")
    public void servletController(Model model,
                                  ServletRequest request,
                                  ServletResponse response, @RequestHeader("Host") String headers) throws IOException {

        response.getWriter().write("hello from servlet responce   header \"Host\" = " + headers);
    }

}
