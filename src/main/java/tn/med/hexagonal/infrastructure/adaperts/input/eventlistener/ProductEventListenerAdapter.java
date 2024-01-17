package tn.med.hexagonal.infrastructure.adaperts.input.eventlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import tn.med.hexagonal.domain.event.ProductCreatedEvent;

@Component
@Slf4j
public class ProductEventListenerAdapter {
    @EventListener
    public void handle(ProductCreatedEvent event){
        log.info("Product created with id " + event.getId() + " at " + event.getDate());
    }
}
