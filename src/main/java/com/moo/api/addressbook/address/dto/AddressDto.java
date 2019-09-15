package com.moo.api.addressbook.address.dto;

import lombok.Data;

@Data
public class AddressDto
{
    private String line1;
    private String line2;
    private String postcode;
    private String city;
    private String country;
}
