package tn.med.hexagonal.application.ports.output;

import tn.med.hexagonal.domain.event.ProductCreatedEvent;

public interface ProductEventPublisher {
    void publishProductCreatedEvent(ProductCreatedEvent event);
}
