package com.example.ChristmasSweather.DAO;

import com.example.ChristmasSweather.HTTPResponse;
import com.example.ChristmasSweather.Models.Product;
import com.example.ChristmasSweather.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDao {
    @Autowired
    ProductRepository productRep;
    @Autowired
    ImageDao imageDao;

    public ProductDao(){}

    public HTTPResponse getProduct(String name){
        if(!name.equals("")){
            Product product = productRep.findByName(name);
            if(product == null) {return HTTPResponse.returnFailure("NO PRODUCTS WHERE FOUND");}
            return HTTPResponse.returnSuccess(product);
        }else{
            List<Product> data = productRep.findAll();
            for(Product product: data){
                if(product.getImage() == null){
                String image = imageDao.constructimg(product.getId());
                product.setImage(image);
                    System.out.println(product.getImage());
                }
            }

            if(data.isEmpty()) {return HTTPResponse.returnFailure("NO PRODUCTS WHERE FOUND");}
            return HTTPResponse.returnSuccess(data);
        }
    }

    public HTTPResponse addProduct(Product product){
        System.out.println(product.getImage());
        Product newproduct = new Product(   product.getName(),
                product.getTotal(),
                product.getDescription(),
                product.getPrice(),
                product.getColor(),
                product.isAvalable(),
                product.getImage(),
                product.getSex(),
                product.getSize());

        if(product.getImage().length() > 250){
            imageDao.saveimg(newproduct);
            newproduct.setImage(null);
        }

        productRep.save(newproduct);
        return HTTPResponse.returnSuccess("Product has been saved");
    }

    public HTTPResponse changeProduct(Product product){
        Optional<Product> productToChange = productRep.findById(product.getId());

        if(productToChange.isEmpty()){
            return HTTPResponse.returnFailure("Could not find a product with id: " + product.getId());
        }

        productToChange.get().setName(product.getName());
        productToChange.get().setDescription(product.getDescription());
        productToChange.get().setPrice(product.getPrice());
        productToChange.get().setImage(product.getImage());
        productToChange.get().setColor(product.getColor());
        productToChange.get().setAvalable(product.isAvalable());
        productToChange.get().setTotal(product.getTotal());
        productToChange.get().setSex(product.getSex());
        productToChange.get().setSize(product.getSize());

        if(productToChange.get().getImage().length() > 250){
            imageDao.saveimg(productToChange.get());
            productToChange.get().setImage(null);
        }

        productRep.save(productToChange.get());

        return HTTPResponse.returnSuccess("Product has changed");
    }

    public HTTPResponse deleteProduct(Product product){
        if(product == null){
            return HTTPResponse.returnFailure("Product does not exist");
        }
        Optional<Product> productToDelete = productRep.findById(product.getId());

        if(productToDelete.isEmpty()){
            return HTTPResponse.<Product[]>returnFailure("could not find a Product with id: " + product.getId());
        }
        productRep.deleteById(productToDelete.get().getId());
        return HTTPResponse.returnSuccess("Product has been deleted");
    }
}