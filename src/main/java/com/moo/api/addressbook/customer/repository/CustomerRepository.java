package com.moo.api.addressbook.customer.repository;

import com.moo.api.addressbook.customer.domain.CustomerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel, Long>
{
    List<CustomerModel> findAllBySurname(String surname);
}
