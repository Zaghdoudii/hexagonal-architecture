package tn.med.hexagonal.domain.exception;

public class ProductNotFound extends RuntimeException{

    public ProductNotFound(String message) {
        super(message);
    }
}
