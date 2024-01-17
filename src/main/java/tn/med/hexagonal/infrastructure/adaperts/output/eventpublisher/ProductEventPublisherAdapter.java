package tn.med.hexagonal.infrastructure.adaperts.output.eventpublisher;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import tn.med.hexagonal.application.ports.output.ProductEventPublisher;
import tn.med.hexagonal.domain.event.ProductCreatedEvent;

@RequiredArgsConstructor
public class ProductEventPublisherAdapter implements ProductEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishProductCreatedEvent(ProductCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
