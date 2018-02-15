package com.avs.api.v1.mapper;

import com.avs.api.v1.model.CustomerDTO;
import com.avs.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface  CustomerMapper {


    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}
