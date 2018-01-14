package com.avs.repositories;

import com.avs.api.v1.model.CustomerDTO;
import com.avs.domain.Category;
import com.avs.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
