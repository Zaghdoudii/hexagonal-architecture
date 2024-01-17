package tn.med.hexagonal.infrastructure.adaperts.output.persistence.mapper;

import org.mapstruct.Mapper;
import tn.med.hexagonal.domain.model.Product;
import tn.med.hexagonal.infrastructure.adaperts.output.persistence.entity.ProductEntity;

@Mapper
public interface ProductPersistenceMapper {

    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);
}
