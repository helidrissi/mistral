package fr.mistral.demomisframe;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {


    @GetMapping("/helloW")
    public String helloWorld(){
        return "Hello world !!!!!!";
    }

    @GetMapping("/helloA")
    public String helloWorldA(){
        return "Hello AfterLife !!!!!!";
    }
}
