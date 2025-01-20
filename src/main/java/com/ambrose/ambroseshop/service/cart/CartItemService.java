package com.ambrose.ambroseshop.service.cart;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.ambrose.ambroseshop.exceptions.ResourceNotFoundException;
import com.ambrose.ambroseshop.model.Cart;
import com.ambrose.ambroseshop.model.CartItem;
import com.ambrose.ambroseshop.model.Product;
import com.ambrose.ambroseshop.repository.CartItemRepository;
import com.ambrose.ambroseshop.repository.CartRepository;
import com.ambrose.ambroseshop.service.product.IProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartItemService implements ICartItemService{
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final IProductService productService;
    private final ICartService cartService;
    
    @Override
    public void addItemToCart(Long cartId, Long productId, int quantity) {
        // get the cart
        // get the product
        // check if the product is already in the cart
        // if it is, update the quantity
        // if it is not, add the product to the cart  
        Cart cart = cartService.getCartById(cartId);
        Product product = productService.getProductById(productId);
        CartItem cartItem = cart.getItems().stream()
            .filter(item -> item.getProduct().getId().equals(productId))
            .findFirst()
            .orElse(new CartItem());
        if (cartItem.getId() == null){
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setUnitPrice(product.getPrice());
            cart.getItems().add(cartItem);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }
        cartItem.setTotalPrice();
        cart.addItem(cartItem);
        cartItemRepository.save(cartItem);
        cartRepository.save(cart);
    }

    @Override
    public void removeItemFromCart(Long cartId, Long productId) {
        Cart cart = cartService.getCartById(cartId);
        CartItem itemToRemove = getCartItem(cartId, productId);
        cart.removeItem(itemToRemove);
        cartRepository.save(cart);
    }

    @Override
    public void updateItemQuantity(Long cartId, Long productId, int quantity) {
        Cart cart = cartService.getCartById(cartId);
        cart.getItems()
        .stream()
        .filter(item -> item.getProduct().getId().equals(productId))
        .findFirst()
        .ifPresent(item -> {
            item.setQuantity(quantity);
            item.setUnitPrice(item.getProduct().getPrice());
            item.setTotalPrice();
        });
        BigDecimal totalAmount = cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);
        cartRepository.save(cart);
    }

    @Override
    public CartItem getCartItem(Long cartId, Long productId) {
        Cart cart = cartService.getCartById(cartId);
        return cart.getItems()
        .stream()
        .filter(item -> item.getProduct().getId().equals(productId))
        .findFirst().orElseThrow(()-> new ResourceNotFoundException("Item not found"));
    }

}
