package com.moo.api.addressbook.customer.controller;

import com.moo.api.addressbook.customer.facade.CustomerFacade;
import com.moo.api.addressbook.customer.view.CustomerContactDetails;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addressbook/api/v1/customer")
public class CustomerController
{

    private CustomerFacade customerFacade;

    public CustomerController(final CustomerFacade customerFacade)
    {
        this.customerFacade = customerFacade;
    }

    @GetMapping(value = "/{surname}",
            produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CustomerContactDetails> getContactDetailsBySurname(@PathVariable final String surname)
    {
        return customerFacade.getContactDetailsForCustomer(surname);
    }
}
