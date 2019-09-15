package com.moo.api.addressbook.customer.controller;

import com.moo.api.addressbook.customer.dto.CustomerDto;
import com.moo.api.addressbook.customer.mapper.CustomerDto2ContactDetailsMapper;
import com.moo.api.addressbook.customer.service.CustomerLookupService;
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
    private CustomerLookupService customerLookupService;
    private CustomerDto2ContactDetailsMapper customerDto2ContactDetailsMapper;

    public CustomerController(final CustomerLookupService customerLookupService,
                              final CustomerDto2ContactDetailsMapper customerDto2ContactDetailsMapper)
    {
        this.customerLookupService = customerLookupService;
        this.customerDto2ContactDetailsMapper = customerDto2ContactDetailsMapper;
    }

    @GetMapping(value = "/{surname}",
            produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CustomerContactDetails getContactDetailsBySurname(@PathVariable final String surname)
    {
        final CustomerDto customer = customerLookupService.findBySurname(surname);

        return customerDto2ContactDetailsMapper.map(customer);
    }
}
