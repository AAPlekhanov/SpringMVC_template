package controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @Value("${name}")
    String nameFromPropertise;

    // если метод возвращает не String , то имя для view будет равно маппингу
    @RequestMapping(path = {"/hello"}, method = RequestMethod.GET)
    public String hello(Model model){

        model.addAttribute("message", "Hello world from Controller " + nameFromPropertise);
        // если есть только значение без ключа , то ключ будет равен типу
        model.addAttribute("Max");


        return "hello";
    }

    @RequestMapping("/hello2")
    @ResponseBody
    // @RequestParam int integer - имя параметра integer
    public String hello2(@RequestParam("first") String first , @RequestParam(required = false, defaultValue = "default") String second, @RequestParam int integer) {
        return first + second + integer;
    }



    @RequestMapping("/hello3/{one}/two/{three}")
    @ResponseBody
    public String hello3(@PathVariable("one") String one, @PathVariable int three) {
        return one + three;
    }


}
