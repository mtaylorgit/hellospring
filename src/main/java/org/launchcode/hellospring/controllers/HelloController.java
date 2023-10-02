//package org.launchcode.hellospring.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@ResponseBody//You can put this up here and delete all the others below
//@RequestMapping("hello")//you can also put this up here - and it affects the route below, so
//public class HelloController {
//    //Handles request at path localhost:8080/hello
////    @GetMapping("hello")//NOTE we use @PostMapping to do post requests
////    @ResponseBody
////    public String hello() {
////        return "Hello, Spring!";
////    }
//    //this handles request at /goodbye returns a static response
//    @GetMapping("goodbye")//putting this above at the top, you can just see that it lives at /hello/goodbye
//    @ResponseBody
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }
//
//    //create a handler that handles requests of /hello?name=LaunchCode you have to type localhost:8080/hello?name=name
////    @GetMapping("hello")//dynamic handler - so it accepts data
////    @PostMapping("hello")
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")//putting this above at the top, you can just see that it lives at /hello/hello
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }
//
//    //Handles requests of the form /hello/Launchcode
//    @GetMapping("hello/{name}")
//    @ResponseBody
//    public String helloWithPathParam(@PathVariable String name) {
//        return "hello, " + name + "!";
//    }
//
//
//    @GetMapping("form")
//   // @ResponseBody - this is removed when you return a template
//    public String helloForm(){//here now you just return the name of the template
//            return "form";
//    }
//}
package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode
//    @GetMapping("hello/{name}")
//    @ResponseBody
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Cereal");
        names.add("Chocolate");
        names.add("Donuts");
        model.addAttribute("names", names);//first argument "names" is the variable the template will see, second argument is the value that attribute should have
        return "hello-list";
    }

}