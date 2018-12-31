package demo.exception;

public class EntityNotFoundException extends RuntimeException {

    private String type;

    public EntityNotFoundException(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
