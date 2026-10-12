package com.techbizz.westminster.classpractise.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ProductControllerTests {
    @Autowired
    private WebApplicationContext context;
    @Test
    void postedJsonProductCanBeRetrieved() throws Exception {
        var mvc = MockMvcBuilders.webAppContextSetup(context).build();

        for (String path : new String[]{"/products/"}) {
            mvc.perform(post(path)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("""
                                    {"name":"Laptop","qty":2,"inStock":true,"unitPrice":199.99}
                                    """))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name").value("Laptop"));
        }

        mvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.qty").value(2))
                .andExpect(jsonPath("$.inStock").value(true))
                .andExpect(jsonPath("$.unitPrice").value(199.99));
    }
}
