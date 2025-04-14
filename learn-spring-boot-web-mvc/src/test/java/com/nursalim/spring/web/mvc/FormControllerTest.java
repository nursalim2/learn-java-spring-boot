package com.nursalim.spring.web.mvc;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class FormControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testFormHello() throws Exception {
        mockMvc.perform(
          post("/form/hello")
                  .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                  .param("name", "Nursalim")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Nursalim"))
        );
    }

    @Test
    void testFormHelloResponseHtml() throws Exception {
        mockMvc.perform(
                post("/form/hello")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Nursalim")
        ).andExpectAll(
                status().isOk(),
                header().string(HttpHeaders.CONTENT_TYPE, Matchers.containsString(MediaType.TEXT_HTML_VALUE)),
                content().string(Matchers.containsString("Hello Nursalim"))
        );
    }

    @Test
    void testFormPerson() throws Exception {
        mockMvc.perform(
                post("/form/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Nursalim")
                        .param("birthDate", "2025-04-13")
                        .param("address", "Jakarta")

        ).andExpectAll(
          status().isOk(),
                content().string("Name : Nursalim, Birth Date : 2025-04-13, Address : Jakarta")
        );
    }
}
