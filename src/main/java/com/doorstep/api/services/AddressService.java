package com.doorstep.api.services;

import com.doorstep.api.models.Address;
import com.doorstep.api.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAll(){
        return addressRepository.findAll();
    }

    public  Address create(Address address){
        return addressRepository.save(address);
    }


    public String deleteCustomer(int id) {
        addressRepository.deleteById(id);
        return "Address deleted";
    }

}
