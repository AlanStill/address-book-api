package com.moo.api.addressbook.customer.service.impl;

import com.moo.api.addressbook.customer.domain.CustomerModel;
import com.moo.api.addressbook.customer.dto.CustomerDto;
import com.moo.api.addressbook.customer.mapper.Customer2DtoMapper;
import com.moo.api.addressbook.customer.repository.CustomerRepository;
import com.moo.api.addressbook.customer.service.CustomerLookupService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCustomerLookupService implements CustomerLookupService
{
    private CustomerRepository repository;
    private Customer2DtoMapper mapper;

    public DefaultCustomerLookupService(final CustomerRepository repository, final Customer2DtoMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<CustomerDto> findBySurname(final String surname)
    {
        if (StringUtils.isEmpty(surname))
        {
            return null;
        }

        final List<CustomerModel> customers = repository.findAllBySurnameIgnoreCase(surname);

        return customers.stream()
                .map(c -> mapper.map(c))
                .collect(Collectors.toList());
    }



}
