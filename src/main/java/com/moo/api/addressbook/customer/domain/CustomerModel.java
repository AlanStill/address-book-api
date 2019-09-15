package com.moo.api.addressbook.customer.domain;

import com.moo.api.addressbook.address.domain.AddressModel;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class CustomerModel
{
    @Id
    @GeneratedValue
    private Long customerId;

    @NotNull(message = "firstname is required")
    private String firstname;
    @NotNull(message = "surname is required")
    private String surname;
    private String email;
    private String phoneNumber;

    @NotNull(message = "address is required")
    @Embedded
    private AddressModel address;
}
