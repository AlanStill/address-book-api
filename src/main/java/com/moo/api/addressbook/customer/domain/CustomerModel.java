package com.moo.api.addressbook.customer.domain;

import com.moo.api.addressbook.address.domain.AddressModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CustomerModel
{
    @NotNull(message = "firstname is required")
    private String firstname;
    @NotNull(message = "surname is required")
    private String surname;
    private String email;
    private String phoneNumber;

    @NotNull(message = "address is required")
    private AddressModel address;
}
