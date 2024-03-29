package com.example.springcrudaddtocart.converter;


import com.example.springcrudaddtocart.entity.OrderDetailEntity;
import com.example.springcrudaddtocart.model.OrderDetail;

public class OrderDetailConverter {
    public static OrderDetailEntity trasferToEntity(OrderDetail model){
        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setOrder(OrderConverter.transferToEntityForOrderDetails(model.getOrder()));
        entity.setProduct( ProductConverter.transferToEntityForOrderDetail(model.getProduct()));
        entity.setQuantity(model.getQuantity());
        return entity;
    }
    public static OrderDetail transferToModel(OrderDetailEntity entity){
        OrderDetail model = new OrderDetail();
        model.setId(entity.getId());
        model.setOrder(OrderConverter.transferToModel(entity.getOrder()));
        model.setProduct(ProductConverter.transferToModel(entity.getProduct()));
        model.setQuantity(entity.getQuantity());
        return model;
    }
}
