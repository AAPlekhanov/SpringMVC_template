package controllers;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionCatcher {

    @ExceptionHandler(MyExceptionController.MyRuntimeException.class)
    @ResponseBody
    public String catchException() {
        return "Exception Catched!";
    }
}
