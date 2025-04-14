package com.nursalim.spring.web.mvc;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "Nursalim")
                        .param("middleName", "Milasrun")
                        .param("lastName", "Yayaya")
                        .param("email", "nursalim@mail.com")
                        .param("phone", "1234")
                        .param("address.street", "Ranco")
                        .param("address.city", "Jakarta")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "40144")
        ).andExpectAll(
          status().isOk(),
                content().string(Matchers.containsString("Success create person Nursalim Milasrun Yayaya " +
                        "with email nursalim@mail.com and phone 1234 "+
                        "with address Ranco, Jakarta, Indonesia, 40144"))
        );
    }
}
