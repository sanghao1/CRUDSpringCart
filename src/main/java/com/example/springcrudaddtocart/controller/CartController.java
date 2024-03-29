package com.example.springcrudaddtocart.controller;


import com.example.springcrudaddtocart.model.Order;
import com.example.springcrudaddtocart.model.OrderDetail;
import com.example.springcrudaddtocart.service.CartService;
import com.example.springcrudaddtocart.service.OrderService;
import com.example.springcrudaddtocart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("shoppingCart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @GetMapping("addToCart/{productId}")
    public String addToCart(@PathVariable("productId") Long productId){
        cartService.addToCart(productService.getProductById(productId));
        return "redirect:/shoppingCart/viewCart";
    }
    @GetMapping("viewCart")
    public String viewCart(@ModelAttribute OrderDetail orderDetail,
                           Model model){
        model.addAttribute("items", cartService.getShoppingCart());
        return "cart/itemsCart";
    }
    @GetMapping("removeItem/{cartId}")
    public String viewCart(@PathVariable("cartId") int cartId,
                           @ModelAttribute OrderDetail orderDetail,
                           Model model){
        cartService.removeItem(cartId);
        return "redirect:/shoppingCart/viewCart";
    }
    @GetMapping("checkOut")
    public String getFormCheckOut(@ModelAttribute Order order, Model model){
        model.addAttribute("order",order);
        return "cart/checkOut";
    }
    @PostMapping("checkOut")
    public String checkOut(@ModelAttribute Order order, Model model){
        orderService.saveOrderWithOrderDetail(order,cartService.getShoppingCart());
//        List<Order> orders = orderService.getAllOrder();
        model.addAttribute("orders",orderService.getAllOrder());
        return "cart/listOrder";
    }
    @GetMapping("orderDetail/{orderId}")
    public String getOrderDetail(@PathVariable("orderId") Long orderId, Model model){
        List<OrderDetail> details = orderService.getOrderDetailByOrder(orderId);
        model.addAttribute("details", details);
        return "cart/orderDetails";
    }
}