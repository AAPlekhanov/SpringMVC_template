package controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class MyExceptionController {

    @GetMapping("/exception")
    public void testException() {
        throw new MyRuntimeException();
    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND , reason = "Exception reason text")
    class MyRuntimeException extends RuntimeException {

    }
}
