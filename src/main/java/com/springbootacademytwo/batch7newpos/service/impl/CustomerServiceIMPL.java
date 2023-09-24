package com.springbootacademytwo.batch7newpos.service.impl;



import com.springbootacademytwo.batch7newpos.dto.CustomerDTO;
import com.springbootacademytwo.batch7newpos.dto.request.CustomerUpdateDTO;
import com.springbootacademytwo.batch7newpos.entity.Customer;
import com.springbootacademytwo.batch7newpos.repo.CustomerRepo;
import com.springbootacademytwo.batch7newpos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

@Autowired
private CustomerRepo customerRepo;



    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
      //  System.out.println(customerDTO.getCustomerAddress());
        //return customerDTO.getCustomerName();
        Customer customer = new Customer(

                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
   Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

   customer.setCustomerName(customerUpdateDTO.getCustomerName());
   customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
   customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

   customerRepo.save(customer);
   return customerUpdateDTO.getCustomerName() + "Updated Succesful";


        }else{
throw new RuntimeException("no data found for that id");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(

                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );


            return customerDTO;

        } else {
            throw new RuntimeException("NO Customer");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer customer : getAllCustomers){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()

            );
                customerDTOList.add(customerDTO);
        }

        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "deleted successfully" + customerId;

        }
        else{
            throw new RuntimeException("No Customer Found in that ID");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> getAllCustomers = customerRepo.findAllByActiveEquals(activeState);

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer customer : getAllCustomers){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()

            );
            customerDTOList.add(customerDTO);
        }

        return customerDTOList;
    }


}
