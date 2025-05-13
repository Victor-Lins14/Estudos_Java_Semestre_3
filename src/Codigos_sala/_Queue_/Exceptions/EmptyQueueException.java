package Codigos_sala._Queue_.Exceptions;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException(String message) {
        super(message);
    }
    public EmptyQueueException(){}
}
