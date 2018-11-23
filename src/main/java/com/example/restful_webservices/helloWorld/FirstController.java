package com.example.restful_webservices.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Created by gsati on 8/21/2018.
 */
@RestController
public class FirstController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String helloMethod(){

        return "Hello World";
    }


    @GetMapping(path = "/helloBean")
    public HelloWorld helloMethoBean(){

        return new HelloWorld("Hello world");
    }

    @GetMapping(path = "/helloPathVariable/{name}")
    public HelloWorld helloMethoPathVariable(@PathVariable String name){

        return new HelloWorld(String.format("Hello world, %S", name));
    }
    @GetMapping(path = "/helloBean-internationalization")
    public String helloMethoBeanInternationalization(
            @RequestHeader(name="Accept-Language", required=false) Locale locale){

        return messageSource.getMessage("good.morning.message",null,locale);
    }
    @GetMapping(path = "/helloBean-internationalization1")
    public String helloMethoBeanInternationalization1(){

        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }

}
