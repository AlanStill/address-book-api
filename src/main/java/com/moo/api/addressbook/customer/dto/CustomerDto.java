package com.moo.api.addressbook.customer.dto;

import com.moo.api.addressbook.address.dto.AddressDto;
import lombok.Data;

@Data
public class CustomerDto
{
    private String firstname;
    private String surname;
    private String phoneNumber;
    private String email;

    private AddressDto address;
}
