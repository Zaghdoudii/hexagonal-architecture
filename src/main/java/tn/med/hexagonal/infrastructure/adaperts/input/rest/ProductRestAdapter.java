package tn.med.hexagonal.infrastructure.adaperts.input.rest;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.med.hexagonal.application.ports.input.CreateProductUseCase;
import tn.med.hexagonal.application.ports.input.GetProductUseCase;
import tn.med.hexagonal.domain.model.Product;
import tn.med.hexagonal.infrastructure.adaperts.input.rest.data.request.ProductCreateRequest;
import tn.med.hexagonal.infrastructure.adaperts.input.rest.data.response.ProductCreateResponse;
import tn.med.hexagonal.infrastructure.adaperts.input.rest.data.response.ProductQueryResponse;
import tn.med.hexagonal.infrastructure.adaperts.input.rest.mapper.ProductRestMapper;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductRestAdapter {
    private final CreateProductUseCase createProductUseCase;

    private final GetProductUseCase getProductUseCase;

    private final ProductRestMapper productRestMapper;

    @PostMapping(value = "/products")
    public ResponseEntity<ProductCreateResponse> createProduct(@RequestBody @Valid ProductCreateRequest productCreateRequest){
        // Request to domain
        Product product = productRestMapper.toProduct(productCreateRequest);

        product = createProductUseCase.createProduct(product);

        // Domain to response
        return new ResponseEntity<>(productRestMapper.toProductCreateResponse(product), HttpStatus.CREATED);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<ProductQueryResponse> getProduct(@PathVariable Long id){
        Product product = getProductUseCase.getProductById(id);
        return new ResponseEntity<>(productRestMapper.toProductQueryResponse(product), HttpStatus.OK);
    }

}
