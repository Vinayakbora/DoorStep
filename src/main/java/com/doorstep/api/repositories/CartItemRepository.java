package com.doorstep.api.repositories;

import com.doorstep.api.models.CartItem;
import com.doorstep.api.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {

    public List<CartItem> findByCustomer(Customer customer);

}
