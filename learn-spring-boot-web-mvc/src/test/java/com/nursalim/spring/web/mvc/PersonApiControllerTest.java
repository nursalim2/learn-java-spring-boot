package com.nursalim.spring.web.mvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nursalim.spring.web.mvc.model.CreateAddressRequest;
import com.nursalim.spring.web.mvc.model.CreatePersonRequest;
import com.nursalim.spring.web.mvc.model.CreateSocialMediaRequest;
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


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testCreatePersonApi() throws Exception {
        CreatePersonRequest request= new CreatePersonRequest();
        request.setFirstName("Nursalim");
        request.setMiddleName("Milasrun");
        request.setLastName("Losari");
        request.setEmail("nursalim@mail.com");
        request.setPhone("1233");
        request.setAddress(new CreateAddressRequest("Ranco", "Jaksel", "Indonesia", "40133"));
        request.setHobbies(List.of("Mangan", "Turu"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreateSocialMediaRequest("facebook", "Facebook.com/Nursalim2"));

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk(),
                content().json(objectMapper.writeValueAsString(request))
        );
    }

    @Test
    void createPersonValidationError() throws Exception {
        CreatePersonRequest request= new CreatePersonRequest();
        request.setMiddleName("Milasrun");
        request.setLastName("Losari");
        request.setAddress(new CreateAddressRequest("Ranco", "Jaksel", "Indonesia", "40133"));
        request.setHobbies(List.of("Mangan", "Turu"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreateSocialMediaRequest("facebook", "Facebook.com/Nursalim2"));

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
          status().isBadRequest(),
                content().string(Matchers.containsString("Validation Error"))
        );
    }
}
