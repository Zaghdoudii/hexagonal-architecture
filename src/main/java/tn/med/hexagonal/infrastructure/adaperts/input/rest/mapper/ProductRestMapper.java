package tn.med.hexagonal.infrastructure.adaperts.input.rest.mapper;

import org.mapstruct.Mapper;
import tn.med.hexagonal.domain.model.Product;
import tn.med.hexagonal.infrastructure.adaperts.input.rest.data.request.ProductCreateRequest;
import tn.med.hexagonal.infrastructure.adaperts.input.rest.data.response.ProductCreateResponse;
import tn.med.hexagonal.infrastructure.adaperts.input.rest.data.response.ProductQueryResponse;

@Mapper
public interface ProductRestMapper {

    Product toProduct(ProductCreateRequest productCreateRequest);

    ProductCreateResponse toProductCreateResponse(Product product);

    ProductQueryResponse toProductQueryResponse(Product product);
}
