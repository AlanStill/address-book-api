package com.moo.api.addressbook.customer.facade.impl;

import com.moo.api.addressbook.customer.dto.CustomerDto;
import com.moo.api.addressbook.customer.facade.CustomerFacade;
import com.moo.api.addressbook.customer.mapper.CustomerDto2ContactDetailsMapper;
import com.moo.api.addressbook.customer.service.CustomerLookupService;
import com.moo.api.addressbook.customer.view.CustomerContactDetails;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultCustomerFacade implements CustomerFacade
{
    private static final String SURNAME_NOT_FOUND_ERROR = "Surname Not Found";
    private CustomerLookupService customerLookupService;
    private CustomerDto2ContactDetailsMapper customerDto2ContactDetailsMapper;

    public DefaultCustomerFacade(final CustomerLookupService customerLookupService,
                              final CustomerDto2ContactDetailsMapper customerDto2ContactDetailsMapper)
    {
        this.customerLookupService = customerLookupService;
        this.customerDto2ContactDetailsMapper = customerDto2ContactDetailsMapper;
    }

    @Override
    public List<CustomerContactDetails> getContactDetailsForCustomer(final String surname)
    {
        final List<CustomerDto> customers = customerLookupService.findBySurname(surname);

        if (CollectionUtils.isEmpty(customers))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, SURNAME_NOT_FOUND_ERROR);
        }

        return customers.stream()
                .map(customer -> customerDto2ContactDetailsMapper.map(customer))
                .collect(Collectors.toList());
    }
}
