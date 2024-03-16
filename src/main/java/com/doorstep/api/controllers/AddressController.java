package com.doorstep.api.controllers;

import com.doorstep.api.beans.ResponseHandler;
import com.doorstep.api.models.Address;
import com.doorstep.api.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseHandler.createResponse("Found Address", HttpStatus.OK, addressService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Address address) {
        Address address1 = addressService.create(address);
        return ResponseHandler.createResponse("Address Created", HttpStatus.CREATED, address1);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable int id) {
        return String.valueOf(new ResponseEntity<>(addressService.deleteCustomer(id), HttpStatus.OK));
    }

}
