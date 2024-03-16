package com.doorstep.api.controllers;

import com.doorstep.api.beans.ResponseHandler;
import com.doorstep.api.models.CartItem;
import com.doorstep.api.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart_items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;


    @GetMapping("/")
    public ResponseEntity<?> getAllCartItems() {
        return ResponseHandler.createResponse("Found Cart Item", HttpStatus.OK, cartItemService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCartItems(@PathVariable int id) {
        return ResponseHandler.createResponse("Found Cart Item", HttpStatus.OK, cartItemService.getCartItem(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> createCartItem(@RequestBody CartItem cartItem) {
        CartItem createdCartItem = cartItemService.createCartItem(cartItem);
        return ResponseHandler.createResponse("Cart Item Created", HttpStatus.CREATED, createdCartItem);
    }

    @DeleteMapping("/{id}")
    public String deleteCartItem(@PathVariable int id) {
        return String.valueOf(new ResponseEntity<>(cartItemService.deleteCartItem(id), HttpStatus.OK));
    }
}

