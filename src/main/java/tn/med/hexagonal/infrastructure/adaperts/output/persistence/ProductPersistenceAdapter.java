package tn.med.hexagonal.infrastructure.adaperts.output.persistence;

import lombok.RequiredArgsConstructor;
import tn.med.hexagonal.application.ports.output.ProductOutputPort;
import tn.med.hexagonal.domain.model.Product;
import tn.med.hexagonal.infrastructure.adaperts.output.persistence.entity.ProductEntity;
import tn.med.hexagonal.infrastructure.adaperts.output.persistence.mapper.ProductPersistenceMapper;
import tn.med.hexagonal.infrastructure.adaperts.output.persistence.repository.ProductRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductOutputPort {

    private final ProductRepository productRepository;

    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toProductEntity(product);
        productEntity = productRepository.save(productEntity);
        return productPersistenceMapper.toProduct(productEntity);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);

        if(productEntity.isEmpty()) {
            return Optional.empty();
        }

        Product product = productPersistenceMapper.toProduct(productEntity.get());
        return Optional.of(product);
    }

}
