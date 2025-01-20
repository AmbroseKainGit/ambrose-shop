package com.ambrose.ambroseshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ambrose.ambroseshop.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteAllByCartId(Long id);
}
