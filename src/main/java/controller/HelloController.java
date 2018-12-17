package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {


    // если метод возвращает не String , то имя для view будет равно маппингу
    @RequestMapping(path = {"/hello"}, method = RequestMethod.GET)
    public String hello(Model model){

        model.addAttribute("message", "Hello world from Controller");
        model.addAttribute("Max");
        model.addAttribute("Mike");

        return "hello";
    }

    @RequestMapping("/hello2")
    @ResponseBody
    // @RequestParam int integer - имя параметра integer
    public String hello2(@RequestParam("first") String first , @RequestParam(required = false, defaultValue = "default") String second, @RequestParam int integer) {
        return first + second + integer;
    }




}
