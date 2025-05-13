package Codigos_sala._Queue_.Exceptions;

public class FullQueueException extends RuntimeException {
    public FullQueueException(String message) {
        super(message);
    }
    public FullQueueException(){}
}
