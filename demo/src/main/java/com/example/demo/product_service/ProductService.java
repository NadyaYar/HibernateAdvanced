package com.example.demo.product_service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDescription;
import com.example.demo.entity.ProductParameter;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    void init() {
        Product product = new Product("laptop", BigDecimal.valueOf(12000));
        Product product1 = new Product("earphones", BigDecimal.valueOf(1200));
        Product product2 = new Product("phone charger", BigDecimal.valueOf(550));

        ProductDescription productDescription = new ProductDescription("Modern laptop for business users with the latest " +
                "11th generation Intel® Core™ processor. ");
        ProductDescription productDescription1 = new ProductDescription("Modern headphones with high-quality sound");
        ProductDescription productDescription2 = new ProductDescription("Fast charging for the phone");

        ProductParameter productParameter = new ProductParameter("new");
        ProductParameter productParameter1 = new ProductParameter("old");

        Category category = new Category("laptops");
        Category category1 = new Category("headphone");
        Category category2 = new Category("phone accessories");
        Category category3 = new Category("devices");
        Category category4 = new Category("electronic");

        product.setDescription(productDescription);
        product1.setDescription(productDescription1);
        product2.setDescription(productDescription2);

        product.setProductParameter(productParameter1);
        product1.setProductParameter(productParameter);
        product2.setProductParameter(productParameter);

        product.setCategories(Arrays.asList(category,category3,category4));
        product1.setCategories(Arrays.asList(category1,category2,category4));
        product2.setCategories(Arrays.asList(category2,category4));

        productRepository.saveAll(Arrays.asList(product, product1, product2));
    }


    public Product createProduct(Product product) {
      return productRepository.save(product);
    }


    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }
}
