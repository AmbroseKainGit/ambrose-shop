package com.ambrose.ambroseshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ambrose.ambroseshop.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {


    

}
