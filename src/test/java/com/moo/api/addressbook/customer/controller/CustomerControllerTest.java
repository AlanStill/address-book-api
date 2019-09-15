package com.moo.api.addressbook.customer.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest
{

    private static final String REQUEST = "/addressbook/api/v1/customer/";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void returnStatus200_ForValidRequest() throws Exception
    {
        final String surname = "Smith";

        final String input = REQUEST + surname;
        mockMvc.perform(get(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.surname").value(surname))
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
