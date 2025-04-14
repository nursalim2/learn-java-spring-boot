package com.nursalim.spring.web.mvc;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class DateControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void date() throws Exception {
        mockMvc.perform(
                get("/date")
                        .queryParam("date", "2025-04-13")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Date : 20250413"))
        );
    }

    @Test
    public void dateWithResponseBody() throws Exception {
        mockMvc.perform(
                get("/date2")
                        .queryParam("date", "2025-04-13")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Date : 20250413"))
        );
    }
}
