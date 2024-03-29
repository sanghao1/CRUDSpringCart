package com.example.springcrudaddtocart.converter;


import com.example.springcrudaddtocart.entity.OrderEntity;
import com.example.springcrudaddtocart.model.Order;

public class OrderConverter {
    public static Order transferToModel(OrderEntity entity){
        Order model = new Order();
        model.setId(entity.getId());
        model.setOrderDate(entity.getOrderDate());
        model.setCustomerName(entity.getCustomerName());
        model.setCustomerAddress(entity.getCustomerAddress());
        model.setOrderDetails(entity.getOrderDetails());
        return model;
    }
    public static OrderEntity transferToEntity(Order model){
        OrderEntity entity = new OrderEntity();
        entity.setOrderDate(model.getOrderDate());
        entity.setCustomerName(model.getCustomerName());
        entity.setCustomerAddress(model.getCustomerAddress());
        return entity;
    }

    public static OrderEntity transferToEntityForOrderDetails(Order model){
        OrderEntity entity = new OrderEntity();
        entity.setId(model.getId());
        entity.setOrderDate(model.getOrderDate());
        entity.setCustomerName(model.getCustomerName());
        entity.setCustomerAddress(model.getCustomerAddress());
        return entity;
    }
}
