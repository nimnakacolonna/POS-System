package com.springbootacademytwo.batch7newpos.service;

import com.springbootacademytwo.batch7newpos.dto.CustomerDTO;
import com.springbootacademytwo.batch7newpos.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerid);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByActiveState(boolean activeState);
}
