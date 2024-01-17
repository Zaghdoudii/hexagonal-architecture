package tn.med.hexagonal.infrastructure.adaperts.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tn.med.hexagonal.domain.service.ProductService;
import tn.med.hexagonal.infrastructure.adaperts.output.eventpublisher.ProductEventPublisherAdapter;
import tn.med.hexagonal.infrastructure.adaperts.output.persistence.ProductPersistenceAdapter;
import tn.med.hexagonal.infrastructure.adaperts.output.persistence.mapper.ProductPersistenceMapper;
import tn.med.hexagonal.infrastructure.adaperts.output.persistence.repository.ProductRepository;

@Configuration
public class BeanConfiguration {
//    @Bean
//    public ProductPersistenceAdapter productPersistenceAdapter(ProductRepository productRepository, ProductPersistenceMapper productPersistenceMapper) {
//        return new ProductPersistenceAdapter(productRepository, productPersistenceMapper);
//    }

    @Bean
    public ProductPersistenceAdapter productPersistenceAdapter(ProductRepository productRepository, ProductPersistenceMapper productPersistenceMapper) {
        return new ProductPersistenceAdapter(productRepository, productPersistenceMapper);
    }

    @Bean
    public ProductEventPublisherAdapter productEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new ProductEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public ProductService productService(ProductPersistenceAdapter productPersistenceAdapter, ProductEventPublisherAdapter productEventPublisherAdapter) {
        return new ProductService(productPersistenceAdapter, productEventPublisherAdapter);
    }

}
