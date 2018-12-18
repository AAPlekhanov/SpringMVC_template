package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.*;


/**
 * Сервлет читает и выводит на экран выбранный текстовый файл
 */

@Controller
public class FIleController {

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    @ResponseBody
    public String viewFile(@RequestPart("file") MultipartFile file) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(file.getBytes())));

        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()) {
            stringBuilder.append(bufferedReader.readLine());
        }

        return "file -> " + stringBuilder;
    }


    @RequestMapping(value = "file")
    public String inputFilePath(){
        return "file";
    }

}
