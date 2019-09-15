package com.moo.api.addressbook.customer.mapper;

import com.moo.api.addressbook.customer.dto.CustomerDto;
import com.moo.api.addressbook.customer.view.CustomerContactDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerDto2ContactDetailsMapper
{
    CustomerDto2ContactDetailsMapper INSTANCE = Mappers.getMapper(CustomerDto2ContactDetailsMapper.class);

    CustomerContactDetails map(CustomerDto customerDto);
}
