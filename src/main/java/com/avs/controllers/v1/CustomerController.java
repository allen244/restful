package com.avs.controllers.v1;

import com.avs.api.v1.model.CatorgoryListDTO;
import com.avs.api.v1.model.CustomerDTO;
import com.avs.api.v1.model.CustomerListDto;
import com.avs.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDto> getListofCustomers(){

        return new ResponseEntity<CustomerListDto>(new CustomerListDto(customerService.getAllCustomers()),
                HttpStatus.OK);

    }


    @GetMapping({"{id}"})
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id){
        return new ResponseEntity<CustomerDTO>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<CustomerDTO>(customerService.createNewCustomer(customerDTO),
                HttpStatus.CREATED);
    }
}
