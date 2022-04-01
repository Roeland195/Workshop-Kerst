package com.example.ChristmasSweather.DAO;

import com.example.ChristmasSweather.Models.Image;
import com.example.ChristmasSweather.Models.Product;
import com.example.ChristmasSweather.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImageDao {
    @Autowired
    private ImageRepository imageRepository;

    public ImageDao(){}


    public void saveimg(Product product) {
        List<String> parts = new ArrayList<>();
        int length = product.getImage().length();
        for(int i = 0; i < length; i += 250){
            parts.add(product.getImage().substring(i, Math.min(length, i + 250)));
        }

        for (int e = 0; e < parts.size(); e++) {
            System.out.println(parts.get(e));
            Image image = new Image(parts.get(e),e, product.getId());

            imageRepository.save(image);
        }
    }

    public String constructimg(String productid){
        List<Image> productimages = new ArrayList<>();
        List<Image> images = imageRepository.findAll();
        Image wrongorder;
        String url = "";

        for (Image image: images) {
            if(productid.equals(image.getProductid())){
                productimages.add(image);
            }
        }
        if(productimages.size() != 0) {
            for (int g = 0; g < productimages.size(); g++) {
                if (g != productimages.get(g).getImage_order()) {
                    wrongorder = productimages.get(g);
                    productimages.remove(g);
                    productimages.add(wrongorder);
                    g = 0;
                    url = "";
                }
                url = url + productimages.get(g).getImage_part();
            }
        }
        System.out.println(url);
        return url;
    }
}
