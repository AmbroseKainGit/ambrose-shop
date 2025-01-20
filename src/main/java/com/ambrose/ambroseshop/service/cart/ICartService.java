package com.ambrose.ambroseshop.service.cart;

import java.math.BigDecimal;

import com.ambrose.ambroseshop.model.Cart;

public interface ICartService {

    Cart getCartById(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);

}
