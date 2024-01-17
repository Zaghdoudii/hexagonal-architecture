package tn.med.hexagonal.application.ports.output;

import tn.med.hexagonal.domain.model.Product;

import java.util.Optional;

public interface ProductOutputPort {

    Product saveProduct(Product product);

    Optional<Product> getProductById(Long id);
}
