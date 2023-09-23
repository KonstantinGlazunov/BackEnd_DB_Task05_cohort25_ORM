package de.ait.ec.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Endpoint /courses is work: ")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles("test")
class CoursesIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DisplayName("GET /courses")
    public class getCourses {
        @Test
        @Sql(scripts = {"/sql/getData.sql"})
        public void return_empty_list_of_courses() throws Exception {
            mockMvc.perform(get("/api/courses"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()", is(1)))
                    .andExpect((jsonPath("$.[0].id", is(1))))
                    .andExpect((jsonPath("$.[0].title", is("Test course title"))))
                    .andExpect((jsonPath("$.[0].description", is("Test course description"))))
                    .andExpect((jsonPath("$.[0].beginDate", is("2000-01-01"))))
                    .andExpect((jsonPath("$.[0].endDate", is("2000-02-02"))))
                    .andExpect((jsonPath("$.[0].price", is(100.0))))
                    .andExpect((jsonPath("$.[0].state", is("DRAFT"))))
            ;

        }
    }


    @Nested
    @DisplayName("POST /courses")
    public class PostCourses {
        

        @Test
        public void addCourseTest() throws Exception {
            String postJson = "{\"title\":\"Test course title\",\"description\":\"Test course description\",\"beginDate\":\"2000-01-01\",\"endDate\":\"2000-02-02\",\"price\":100.0}";
            String expectedJson = "{\"id\":1,\"title\":\"Test course title\",\"description\":\"Test course description\",\"beginDate\":\"2000-01-01\",\"endDate\":\"2000-02-02\",\"price\":100.0,\"state\":\"DRAFT\"}";

            MvcResult result = mockMvc.perform(post("/api/courses")
                            .contentType("application/json")
                            .content(postJson)
                    ).andExpect(status().isCreated())
                    .andReturn();

            String actualJson = result.getResponse().getContentAsString();
            assertThat(actualJson).isEqualTo(expectedJson);
        }
    }
}





