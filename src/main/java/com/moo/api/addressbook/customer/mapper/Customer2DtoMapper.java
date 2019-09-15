package com.moo.api.addressbook.customer.mapper;

import com.moo.api.addressbook.customer.domain.CustomerModel;
import com.moo.api.addressbook.customer.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Customer2DtoMapper
{
    Customer2DtoMapper INSTANCE = Mappers.getMapper(Customer2DtoMapper.class);
    CustomerDto map(CustomerModel model);
}
