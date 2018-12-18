package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import other.User;

@Controller
@RequestMapping("/form")
public class FormController {

    @GetMapping
    public String myForm(){
        return "myForm";
    }




    /**
     *  из формы приходят параметры  String name и int age ,
     *  можно использовать объект User , через сеттеры в объект User будут засетены  данные из формы
     *
     *   <input name = "name"/>      значение будет записано через setName
     *   <input name = "age" />      значение будет записано через setAge
     *
     *
     */

//    @PostMapping
//    @ResponseBody
//    public String myFormPost(@RequestParam String name, @RequestParam int age){
//        return name + " " + age;
//    }

    @PostMapping
    @ResponseBody
    public String myFormPost(User user){
        return user.getName() + " " + user.getAge();
    }


}
