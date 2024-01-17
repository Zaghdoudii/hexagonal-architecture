package tn.med.hexagonal.domain.service;

import lombok.AllArgsConstructor;
import tn.med.hexagonal.application.ports.input.CreateProductUseCase;
import tn.med.hexagonal.application.ports.input.GetProductUseCase;
import tn.med.hexagonal.application.ports.output.ProductEventPublisher;
import tn.med.hexagonal.application.ports.output.ProductOutputPort;
import tn.med.hexagonal.domain.event.ProductCreatedEvent;
import tn.med.hexagonal.domain.exception.ProductNotFound;
import tn.med.hexagonal.domain.model.Product;

@AllArgsConstructor
public class ProductService implements CreateProductUseCase, GetProductUseCase{

    private final ProductOutputPort productOutputPort;

    private final ProductEventPublisher productEventPublisher;
    @Override
    public Product createProduct(Product product) {
        product = productOutputPort.saveProduct(product);
        productEventPublisher.publishProductCreatedEvent(new ProductCreatedEvent(product.getId()));
        return product;
    }

    @Override
    public Product getProductById(Long id) {
        return productOutputPort.getProductById(id).orElseThrow(() -> new ProductNotFound("Product not found with id " + id));

    }
}
