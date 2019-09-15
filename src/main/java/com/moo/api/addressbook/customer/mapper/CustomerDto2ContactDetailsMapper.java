package com.moo.api.addressbook.customer.mapper;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.moo.api.addressbook.address.dto.AddressDto;
import com.moo.api.addressbook.customer.dto.CustomerDto;
import com.moo.api.addressbook.customer.view.CustomerContactDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerDto2ContactDetailsMapper
{
    CustomerDto2ContactDetailsMapper INSTANCE = Mappers.getMapper(CustomerDto2ContactDetailsMapper.class);

    CustomerContactDetails map(CustomerDto customerDto);

    @Mapping(source = "address", target = "address")
    default String map(AddressDto addressDto)
    {
        final List<String> addressData = Lists.newArrayList(addressDto.getLine1(), addressDto.getLine2(),
                addressDto.getCity(), addressDto.getPostcode(), addressDto.getCountry());

        return Joiner.on(',')
                .skipNulls()
                .join(addressData);
    }
}
