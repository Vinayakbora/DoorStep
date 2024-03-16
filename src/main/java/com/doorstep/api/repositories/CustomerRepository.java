package com.doorstep.api.repositories;

import com.doorstep.api.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByEmail(String email);

    List<Customer> findByEmailOrAge(String email, int age);

    Optional<Customer> findByEmailAndAge(String email, int age);

}
