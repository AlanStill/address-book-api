package com.moo.api.addressbook.customer.service.impl;

import com.moo.api.addressbook.address.domain.AddressModel;
import com.moo.api.addressbook.customer.domain.CustomerModel;
import com.moo.api.addressbook.customer.dto.CustomerDto;
import com.moo.api.addressbook.customer.mapper.Customer2DtoMapper;
import com.moo.api.addressbook.customer.service.CustomerLookupService;
import org.springframework.stereotype.Service;

@Service
public class CustomerLookupServiceImpl implements CustomerLookupService
{
    private Customer2DtoMapper mapper;

    public CustomerLookupServiceImpl(final Customer2DtoMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public CustomerDto findBySurname(final String surname)
    {
        final CustomerModel customer = getCustomer();
        return mapper.map(customer);
    }

    private CustomerModel getCustomer()
    {
        CustomerModel testCustomer = new CustomerModel();
        testCustomer.setFirstname("John");
        testCustomer.setSurname("Smith");
        testCustomer.setEmail("j@smith.com");
        testCustomer.setPhoneNumber("12345678");

        final AddressModel address = new AddressModel();
        address.setLine1("10 Main Street");
        address.setPostcode("QW1 ER4");
        address.setCity("London");
        address.setCountry("United Kingdom");

        testCustomer.setAddress(address);

        return testCustomer;
    }

}
