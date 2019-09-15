package com.moo.api.addressbook.customer.view;

import lombok.Data;

@Data
public class CustomerContactDetails
{
    private String firstname;
    private String surname;
    private String phoneNumber;
    private String email;
    private String address;
}
