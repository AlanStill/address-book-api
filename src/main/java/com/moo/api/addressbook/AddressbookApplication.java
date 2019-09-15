package com.moo.api.addressbook;

import com.google.common.collect.Lists;
import com.moo.api.addressbook.address.domain.AddressModel;
import com.moo.api.addressbook.customer.domain.CustomerModel;
import com.moo.api.addressbook.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class AddressbookApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(AddressbookApplication.class, args);
    }

    @Bean
    public CommandLineRunner setup(final CustomerRepository repository) {
        return (args) -> {

            final List<CustomerModel> customers = createCustomers();
            repository.saveAll(customers);

            System.out.println("Customer Count = " + repository.count());
        };
    }

    private List<CustomerModel> createCustomers()
    {
        CustomerModel testCustomer = new CustomerModel();
        testCustomer.setFirstname("John");
        testCustomer.setSurname("Smith");
        testCustomer.setEmail("j@smith.com");
        testCustomer.setPhoneNumber("12345678");

        final AddressModel address = new AddressModel();
        address.setLine1("10 Main Street");
        address.setPostcode("QW1 ER4");
        address.setCity("London");
        address.setCountry("United Kingdom");
        testCustomer.setAddress(address);

        CustomerModel testCustomer2 = new CustomerModel();
        testCustomer2.setFirstname("Tom");
        testCustomer2.setSurname("Adams");
        testCustomer2.setEmail("tom@email.com");
        testCustomer2.setPhoneNumber("9876543");
        testCustomer2.setAddress(address);

        CustomerModel testCustomer3 = new CustomerModel();
        testCustomer3.setFirstname("Mary");
        testCustomer3.setSurname("Scott");
        testCustomer3.setEmail("mary@email.com");
        testCustomer3.setPhoneNumber("34567654");
        testCustomer3.setAddress(address);

        return Lists.newArrayList(testCustomer, testCustomer2, testCustomer3);
    }


}
