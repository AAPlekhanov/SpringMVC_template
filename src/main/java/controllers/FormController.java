package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/form")
public class FormController {

    @GetMapping
    public String myForm(){
        return "myForm";
    }


    @PostMapping
    @ResponseBody
    public String myFormPost(@RequestParam String name, @RequestParam int age){
        return name + " " + age;
    }


}
