package com.nursalim.spring.web.mvc;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class UploadControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testUpload() throws Exception {
        mockMvc.perform(
                multipart("/upload/profile")
                        .file(new MockMultipartFile("profile", "profile.png", "image/png",
                                getClass().getResourceAsStream("/images/profile.png")))
                        .param("name", "Nursalim")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success save profile Nursalim to upload/profile.png"))
        );
    }
}
