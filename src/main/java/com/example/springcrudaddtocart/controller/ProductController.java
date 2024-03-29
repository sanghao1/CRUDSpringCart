package com.example.springcrudaddtocart.controller;
import com.example.springcrudaddtocart.entity.ProductEntity;
import com.example.springcrudaddtocart.model.Product;
import com.example.springcrudaddtocart.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/home")
    public String getProducts(@ModelAttribute Product product, Model model){
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        model.addAttribute("product", new ProductEntity());
        return "product/productList";
    }

    @GetMapping("addNew")
    public String getFormAddNewProduct(@ModelAttribute Product product, Model model){
        model.addAttribute("product", product);
        return "product/addNewForm";
    }
    @PostMapping("addNew")
    public String addNew(@ModelAttribute @Valid Product product, Model model){
        productService.createProduct(product);
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "product/productList";
    }
}
