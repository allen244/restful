package com.avs.api.v1.mapper;

import com.avs.api.v1.model.CustomerDTO;
import com.avs.domain.Customer;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-01-16T21:02:57-0500",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 1.8.0_121 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setFirstname( customer.getFirstname() );
        customerDTO.setLastname( customer.getLastname() );
        customerDTO.setCustomerUrl( customer.getCustomerUrl() );

        return customerDTO;
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setFirstname( customerDTO.getFirstname() );
        customer.setLastname( customerDTO.getLastname() );
        customer.setCustomerUrl( customerDTO.getCustomerUrl() );

        return customer;
    }
}
