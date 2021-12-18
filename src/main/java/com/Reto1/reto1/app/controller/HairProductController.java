/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.reto1.app.controller;

import com.Reto1.reto1.app.model.HairProduct;
import com.Reto1.reto1.app.services.HairProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sandrita
 */
@RestController
@RequestMapping("hairproducts")
@CrossOrigin(origins="*")

public class HairProductController 
{
    @Autowired
    private HairProductService service;
    
    @GetMapping("/all")
    public List<HairProduct> getHairProduct()
    {
        return service.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct save(@RequestBody HairProduct hairproduct)
    {
        return service.save(hairproduct);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct update(@RequestBody HairProduct hairproduct)
    {
        return service.update(hairproduct);
    }
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference)
    {
        return service.delete(reference);
    }
    @GetMapping("/{reference}")
    public Optional<HairProduct> existEmail(@PathVariable("reference") String reference)
    {
        return service.getByReference(reference);
    }
    
    @GetMapping("/price/{price}")
    public List<HairProduct> getByPrice(@PathVariable("price") String price)
    {
        return service.getProductByPrice(price);
    }
    
    @GetMapping("/description/{description}")
    public List<HairProduct> getByDescription(@PathVariable("description") String description)
    {
        return service.getProductByDescription(description);
    }
    
    
    
    
}
