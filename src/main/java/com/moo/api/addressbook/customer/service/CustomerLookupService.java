package com.moo.api.addressbook.customer.service;

import com.moo.api.addressbook.customer.dto.CustomerDto;

public interface CustomerLookupService
{
    CustomerDto findBySurname(String surname);
}
