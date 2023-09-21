package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody//You can put this up here and delete all the others below
@RequestMapping("hello")//you can also put this up here - and it affects the route below, so
public class HelloController {
    //Handles request at path localhost:8080/hello
//    @GetMapping("hello")//NOTE we use @PostMapping to do post requests
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }
    //this handles request at /goodbye returns a static response
    @GetMapping("goodbye")//putting this above at the top, you can just see that it lives at /hello/goodbye
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //create a handler that handles requests of /hello?name=LaunchCode you have to type localhost:8080/hello?name=name
//    @GetMapping("hello")//dynamic handler - so it accepts data
//    @PostMapping("hello")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")//putting this above at the top, you can just see that it lives at /hello/hello
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/Launchcode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "hello, " + name + "!";
    }


    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
