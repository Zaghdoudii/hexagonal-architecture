package tn.med.hexagonal.infrastructure.adaperts.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.med.hexagonal.infrastructure.adaperts.output.persistence.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
