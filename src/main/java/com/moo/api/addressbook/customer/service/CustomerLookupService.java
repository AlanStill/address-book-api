package com.moo.api.addressbook.customer.service;

import com.moo.api.addressbook.customer.dto.CustomerDto;

import java.util.List;

public interface CustomerLookupService
{
    List<CustomerDto> findBySurname(String surname);
}
