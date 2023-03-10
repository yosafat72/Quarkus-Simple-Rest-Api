package org.acme.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.entity.ProductEntity;
import org.acme.repository.ProductRepository;

@ApplicationScoped
public class ProductService {

    @Inject
    private ProductRepository repository;

    public List<ProductEntity> getProduct() {
        return repository.listAll();
    }

    public ProductEntity getSinglEntity(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void addProduct(ProductEntity product) {
        repository.persist(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public ProductEntity updateProduct(ProductEntity product) {
        ProductEntity entity = repository.findById(product.id);
        entity.name = product.name;
        entity.price = product.price;
        entity.brand = product.brand;
        entity.sector = product.sector;
        return product;
    }

}
