package com.moo.api.addressbook.customer.controller;

import com.moo.api.addressbook.customer.view.CustomerContactDetails;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook/api/v1/customer")
public class CustomerController
{
    @GetMapping(value = "/{surname}",
            produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CustomerContactDetails getContactDetailsBySurname(@PathVariable final String surname)
    {
        CustomerContactDetails customer = new CustomerContactDetails();
        customer.setFirstname("John");
        customer.setSurname("Smith");
        customer.setEmail("jsmith@email.com");
        customer.setPhoneNumber("1234567890");
        customer.setAddress("10 Main Street, London, QW1 ER4, United Kingdom");

        return customer;
    }
}
