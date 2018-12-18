package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Пример редиректа ( "redirect:/redirectTo" даёт указание браузеру перейти по данному url
 * forward перебрасывает на сервлет на стороне сервера )
 */


@Controller
public class RedirectController {



    @RequestMapping("/redirect")
    public String redirectMe () {
        return "redirect:/redirectTo";
    }


    @RequestMapping("/redirectTo")
    @ResponseBody
    public String redirectTo() {
        return "hello from redirected";
    }

}
