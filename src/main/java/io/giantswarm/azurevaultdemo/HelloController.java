package io.giantswarm.azurevaultdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${marco:not secret}")
    private String marcoLastName;

    @RequestMapping("/")
    public String index() {
        return "This is the secret lastname: '" + marcoLastName + "'\n";
    }

}
