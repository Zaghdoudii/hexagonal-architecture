package tn.med.hexagonal.infrastructure.adaperts.input.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateResponse {
    private Long id;

    private String name;

    private String description;
}
