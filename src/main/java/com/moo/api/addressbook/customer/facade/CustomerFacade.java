package com.moo.api.addressbook.customer.facade;

import com.moo.api.addressbook.customer.view.CustomerContactDetails;

import java.util.List;

public interface CustomerFacade
{
    List<CustomerContactDetails> getContactDetailsForCustomer(String surname);
}
