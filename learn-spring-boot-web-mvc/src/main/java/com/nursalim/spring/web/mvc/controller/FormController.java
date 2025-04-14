package com.nursalim.spring.web.mvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FormController {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @PostMapping(path = "/form/hello",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_HTML_VALUE
    )
    @ResponseBody
    public String hello(@RequestParam(name = "name") String name) {
        String html = """
                <html>
                <body>
                <h1>Hello $name</h1>
                </body>
                </html>
                """;
        return html.replace("$name", name);
    }

    @PostMapping(path = "/form/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String createPerson(@RequestParam(name = "name") String name,
                               @RequestParam(name = "birthDate") Date birthDate,
                               @RequestParam(name = "address") String address) {

        return "Name : " + name + ", Birth Date : " + dateFormat.format(birthDate) +
                ", Address : " + address;

    }
}
