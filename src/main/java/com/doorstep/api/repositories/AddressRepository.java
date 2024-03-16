package com.doorstep.api.repositories;

import com.doorstep.api.models.Address;
import com.doorstep.api.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    public List<Address> findByCustomer(Customer customer);

}
