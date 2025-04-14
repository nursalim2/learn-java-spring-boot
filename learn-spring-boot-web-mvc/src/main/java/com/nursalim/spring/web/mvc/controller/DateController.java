package com.nursalim.spring.web.mvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DateController {

    private final DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    @GetMapping("/date")
    public void getDate(@RequestParam(name = "date") Date date,
                        HttpServletResponse response) throws IOException {
        response.getWriter().println("Date : " + dateFormat.format(date));
    }

    @GetMapping("/date2")
    @ResponseBody
    public String getDate2(@RequestParam(name = "date") Date date,
                        HttpServletResponse response) throws IOException {
        return "Date : " + dateFormat.format(date);
    }
}
