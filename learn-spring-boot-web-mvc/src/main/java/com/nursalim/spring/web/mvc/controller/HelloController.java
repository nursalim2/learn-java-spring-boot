package com.nursalim.spring.web.mvc.controller;

import com.nursalim.spring.web.mvc.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public void helloWord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String responseBody = helloService.hello(name);

        response.getWriter().println(responseBody);
    }

    @GetMapping(path = "/hello2")
    public void helloWord2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String responseBody = helloService.hello(name);

        response.getWriter().println(responseBody);
    }

    @GetMapping(path = "/hello3")
    public void helloWordWithRequestParam(@RequestParam(name = "name", required = false) String name ,
                                          HttpServletResponse response) throws IOException {
        String responseBody = helloService.hello(name);

        response.getWriter().println(responseBody);
    }

    @GetMapping(path = "/web/hello")
    public ModelAndView hello(@RequestParam(name = "name", required = false) String name) {
        if(Objects.isNull(name)) {
            return new ModelAndView("redirect:/web/hello?name=Guest");
        }
        return new ModelAndView(
          "hello", Map.of(
                  "title", "Belajar View",
                   "name", name
                  )
        );
    }
}
