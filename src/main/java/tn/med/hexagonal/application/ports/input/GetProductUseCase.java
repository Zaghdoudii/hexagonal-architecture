package tn.med.hexagonal.application.ports.input;

import tn.med.hexagonal.domain.model.Product;

public interface GetProductUseCase {
    Product getProductById(Long id);

}
