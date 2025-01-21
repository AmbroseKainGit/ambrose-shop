package com.ambrose.ambroseshop.service.cart;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ambrose.ambroseshop.exceptions.ResourceNotFoundException;
import com.ambrose.ambroseshop.model.Cart;
import com.ambrose.ambroseshop.repository.CartItemRepository;
import com.ambrose.ambroseshop.repository.CartRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final AtomicLong cartIdGenerator = new AtomicLong(0);

    @Override
    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
        // Cart cart = cartRepository.findById(id).orElseThrow(() -> new
        // ResourceNotFoundException("Cart not found"));
        // BigDecimal totalAmount = cart.getTotalAmount();
        // cart.setTotalAmount(totalAmount);
        // return cartRepository.save(cart);
    }

    @Override
    public void clearCart(Long id) {
        Cart cart = getCartById(id);
        cartItemRepository.deleteAllByCartId(id);
        cart.getItems().clear();
        cartRepository.deleteById(id);
    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        return getCartById(id).getTotalAmount();
    }

    @Override
    public Long initializeNewCart() {
        Cart cart = new Cart();
        cart.setId(cartIdGenerator.incrementAndGet());
        return cartRepository.save(cart).getId();
    }

}
