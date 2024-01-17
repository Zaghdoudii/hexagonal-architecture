package tn.med.hexagonal.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedEvent {

    private Long id;
    private LocalDateTime date;

    public ProductCreatedEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }

}
