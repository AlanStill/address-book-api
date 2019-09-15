package com.moo.api.addressbook.address.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@Data
public class AddressModel
{
    @NotNull(message = "address line 1 is required")
    private String line1;
    private String line2;
    private String postcode;
    @NotNull(message = "city is required")
    private String city;
    @NotNull(message = "country is required")
    private String country;
}
